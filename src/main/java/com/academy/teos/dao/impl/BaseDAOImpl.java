package com.academy.teos.dao.impl;

import com.academy.teos.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author: Руслан
 */
@Transactional(propagation= Propagation.REQUIRED)
@Configurable
public abstract class BaseDAOImpl<T, PK extends Serializable>
        implements BaseDAO<T, PK> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public T persist(T o) {
        this.entityManager.persist(o);
        return o;
    }

    @Override
    public T get(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    @Transactional
    public T merge(T o) {
        return this.entityManager.merge(o);
    }

    @Override
    @Transactional
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

}
