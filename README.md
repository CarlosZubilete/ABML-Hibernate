# AMBL CON HIBERNATE.

Este proyecto es una continuación del anterior:
-> [Hibernate-tp3](https://github.com/CarlosZubilete/java-hibernate-tp3)
-- 

# Alcance del proyecto
Este proyecto tiene fines educativos y busca:
- Comprender el funcionamiento interno de Hibernate
- Implementar manualmente patrones comunes (Repository, Service, Singleton)
- Intencionalmente no se utiliza Spring, para enfocarse en los fundamentos del ORM.

---
# Tennologias:
- PostgreSQL como base de datos
- Hibernate como ORM
- Junit como tester

---
# ¿Cómo inicia el proyecto?

## **1. Conexión a la base de datos (Patrón Singleton)**

A. Implementacion
Se utiliza el patrón de diseño **Singleton** para garantizar que exista 
**una única instancia de** `SessionFactory` durante toda la ejecución de la aplicación.

En el proyecto, esta configuración se encuentra en:
`src/main/java/config/HibernateUtil.java`
La configuración se carga desde:
`src/main/resources/cfg.xml`

**Implementación actual (bloque estático)**

```HibernateUtil.java
static {
    try{
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
        System.err.println("ERROR! Initialing Session Factory" + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

```
Este bloque se ejecuta una única vez en la JVM, asegurando la inicialización del `SessionFactory`.

---
Alternativa más explícita (Singleton clásico)
```HibernateUtil.java
public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    return sessionFactory;
}
```
**Nota**: Esta implementación no es thread-safe. 
En entornos productivos se recomienda usar inicialización estática o mecanismos seguros para concurrencia.
---

**B. Responsabilidades de `HibernateUtil`**

Esta clase cumple tres funciones principales:
    - Crear una única instancia de SessionFactory
    - Proveer sesiones (Session) para interactuar con la base de datos
    - Gestionar el cierre de la conexión
---

## **2. Escritura y lectura de datos (Repository)**

En:
`src/main/java/repository/`
se define una clase genérica `Repository<T>` encargada del acceso a datos.

Su objetivo es abstraer las operaciones básicas del sistema **ABML (Alta, Baja, Modificación y Lectura)**.
```Repositoty.java

public class Repository <T> {
    private final Class<T> entity;

    public Repository(Class<T> entity){
        this.entity = entity;
    }

    public T findById ( Session session ,Long id ) {
        return  session.get(this.entity, id );
    }

    public List<T> findAll(Session session){
        return session
                .createQuery("from " + this.entity.getSimpleName(), this.entity)
                .getResultList();
    }

    public void save(Session session,  T entity){
        session.persist(entity);
    }

    public T update(Session session, T entity){
        return  (T)session.merge(entity);

    }

    public void delete (Session session, T entity) {
         session.remove(entity);
    }
}

```
Este enfoque permite:
    - Reutilización de código
    - Separación de responsabilidades
    - Comprensión del funcionamiento interno de Hibernate
---

## **3. Reglas de negocio (Service)**
Una vez definida la conexión y el acceso a datos, se implementa la capa de **servicios**, ubicada en:
`src/main/java/service/`
Esta capa:
    - Orquesta la lógica de negocio
    - Gestiona las transacciones
    - Desacopla la lógica del acceso a datos (Repository.java)

--- 
**Implementación genérica**

```GenericRepository.java

public abstract class GenericService<T> implements IService<T>{

    private final Repository<T> repository;

    public GenericService(Repository<T> repository){
        this.repository = repository;
    }

    @Override
    public T findById(Long id) {
        try (Session session = HibernateUtil.openSession()){
            return repository.findById(session, id);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.openSession()){
            return repository.findAll(session);
        }
    }

    @Override
    public T save(T entity) {
        Transaction tx = null;
            try (Session session = HibernateUtil.openSession()){
                tx = session.beginTransaction();

                repository.save(session, entity);

                tx.commit();
                return entity;
            } catch (Exception e) {
                if(tx != null) tx.rollback();
                throw e;
            }
    }

    @Override
    public T update(T entity) {
        Transaction tx = null;
            try(Session session = HibernateUtil.openSession()){
                tx = session.beginTransaction();

                T merged = repository.update(session, entity);

                tx.commit();
                return merged;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
    }

    @Override
    public boolean delete(Long id) {
        Transaction tx = null;
            try(Session session = HibernateUtil.openSession()){
                tx = session.beginTransaction();

                T entity = this.findById(id);

                if (entity == null ) return  false;

                repository.delete(session,entity);
                tx.commit();

                return true;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
    }
}
```
---

Clase implenata una inerfaz ISevices, debido a que nos queremos asegurar el **contrato de servicio**.

```IService.java
public interface IService<T>{
    public abstract T findById(Long id);
    public abstract List<T> findAll();
    public abstract T save(T entity);
    public abstract T update(T entity);
    public abstract boolean delete (Long id);
}
```
---
B. **Servicios específicos**

Para lógica particular, se pueden extender los servicios genéricos:
```
public class DoctorService extends GenericService<Doctor>{

    public DoctorService(){
        super(new Repository<>(Doctor.class));
    }

    // Aquí se pueden agregar consultas específicas (HQL)
    // Ejemplo: findBySpeciality
}

```

---

**Arquitectura general**
~~~
Service (lógica + transacciones)
        ↓
Repository (acceso a datos - Hibernate)
        ↓
Base de datos (PostgreSQL)
~~~
















