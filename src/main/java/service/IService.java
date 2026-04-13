package service;

import java.util.List;

public interface IService<T>{
    public abstract T findById(Long id);
    public abstract List<T> findAll();
    public abstract T save(T entity);
    public abstract T update(T entity);
    public abstract boolean delete (Long id);
}

