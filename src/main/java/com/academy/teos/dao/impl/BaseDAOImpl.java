package com.academy.teos.dao.impl;

import com.academy.teos.dao.BaseDAO;
import com.academy.teos.dao.BaseRepository;
import com.academy.teos.entity.BaseEntity;
import com.academy.teos.utils.ApplicationContextProvider;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    protected Class<T> entityClass;

    EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (this.entityManager == null) {
            this.entityManager = ((BaseRepository) ApplicationContextProvider.getContext().getBean(
                    "ElectraBaseRepository")).getEntityManager();
        }
        return this.entityManager;
    }

    public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional("transactionManager")
    public T persist(T o) {
        getEntityManager().persist(o);
        return o;
    }

    @Override
    public T get(String id) {
        T obj = null;
        try {
            if (id == null || id.length() == 0) return null;
            obj = getEntityManager().find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    @Transactional("transactionManager")
    public T merge(T o) {
        T merged = getEntityManager().merge(o);
        this.entityManager.flush();
        return merged;
    }

    @Override
    @Transactional("transactionManager")
    public void delete(T t) {
        if (this.entityManager == null) this.entityManager = getEntityManager();
        if (this.entityManager.contains(t)) {
            this.entityManager.remove(t);
        } else {
            T attached = this.get(t.getId());
            this.entityManager.remove(attached);
        }
    }

    @Override
    public T reattach(T o) {
        if (this.entityManager.contains(o)) {
            return o;
        } else {
            T attached = this.get(o.getId());
            return attached;
        }
    }
}
