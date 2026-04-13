package repository;

import org.hibernate.Session;

import java.util.List;

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



/*
public class Repository <T> {

    private final Class<T> entity;

    public Repository(Class<T> entity){
        this.entity = entity;
    }

    public T findById ( Session session ,Long id ) {

        try (Session session = HibernateUtil.openSession()){
            return session.get(entity, id);
        }

    }

    public List<T> findAll(){
            try(Session session = HibernateUtil.openSession()){
                return session
                    .createQuery("from " + entity.getSimpleName(), entity)
                    .getResultList();
            }
    }

    public void save( T entity){

            Transaction tx = null;
            try(Session session = HibernateUtil.openSession()){
                tx = session.beginTransaction();

                session.persist(entity);

                tx.commit();
                return entity;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
    }

    public T update( T entity){
            Transaction tx = null;
            try ( Session session = HibernateUtil.openSession() ){
                tx = session.beginTransaction();

                T merged = (T) session.merge(entity);

                tx.commit();
                return merged;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
    }

    public void delete (T entity) {
            Transaction tx = null;
            try (Session session = HibernateUtil.openSession()) {
                tx = session.beginTransaction();
                T entity = session.get(this.entity, id);

                if(entity == null) {
                    return false;
                }

                session.remove(entity);
                tx.commit();
                return true;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                throw e;
            }
}
*/