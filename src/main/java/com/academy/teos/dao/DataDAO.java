package com.academy.teos.dao;

import com.academy.teos.entity.Data;

/**
 * @author: Руслан
 */
public interface DataDAO extends BaseDAO {

    public Data persist(Data o);

    public Data get(String id);

    public Data merge(Data o);

    public void delete(Data o);
}
