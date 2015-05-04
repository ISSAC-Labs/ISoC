package com.issac.isoc.dao;

/**
 * Created by OPSKMC on 5/4/15.
 */
public interface DAOOperations<T> {
    public void saveOrUpdate(T instance);
    public T getInstance(Integer id);
}
