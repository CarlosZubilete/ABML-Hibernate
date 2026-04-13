package service;

import config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.Repository;

import java.util.List;

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

                T entity = repository.findById(session,id);

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
