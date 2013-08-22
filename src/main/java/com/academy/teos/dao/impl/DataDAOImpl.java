package com.academy.teos.dao.impl;

import com.academy.teos.dao.DataDAO;
import com.academy.teos.entity.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author: Руслан
 */
@Repository
@Configurable
public class DataDAOImpl extends BaseDAOImpl implements DataDAO {

    public static final Logger LOG = Logger.getLogger(DataDAOImpl.class);

    public DataDAOImpl() {
        super(Data.class);
    }

    public static final EntityManager entityManager() {
        EntityManager em = new UserAccountDAOImpl().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public Data persist(Data o) {
        return (Data) super.persist(o);
    }

    public Data get(String id) {
        return (Data) super.get(id);
    }

    public Data merge(Data o) {
        return (Data) super.merge(o);
    }

    public void delete(Data o) {
        super.delete(o);
    }
}
