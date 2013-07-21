package com.academy.teos.dao.impl;

import com.academy.teos.dao.DataDAO;
import com.academy.teos.entity.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author: Руслан
 */
@Repository
public class DataDAOImpl extends BaseDAOImpl implements DataDAO {

    public static final Logger LOG = Logger.getLogger(DataDAOImpl.class);

    public DataDAOImpl() {
        super(Data.class);
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
