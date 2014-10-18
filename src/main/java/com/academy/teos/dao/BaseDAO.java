package com.academy.teos.dao;

import com.academy.teos.entity.BaseEntity;

public interface BaseDAO<T extends BaseEntity> {

    public T persist(T o);

    public T get(String id);

    public T merge(T o);

    public void delete(T o);

    public T reattach(T o);

}