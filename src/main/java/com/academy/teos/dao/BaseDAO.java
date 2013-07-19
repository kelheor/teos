package com.academy.teos.dao;

import java.io.Serializable;

/**
 * @author: Руслан
 */
public interface BaseDAO<T, PK extends Serializable> {

    public T persist(T o);

    public T get(PK id);

    public T update(T o);

    public void delete(T o);


}
