package com.academy.teos.dao;

import com.academy.teos.entity.APIKey;

/**
 * @author: Kelheor
 */
public interface APIKeyDAO extends BaseDAO {

    public APIKey persist(APIKey o);

    public APIKey get(String id);

    public APIKey merge(APIKey o);

    public void delete(APIKey o);

    public boolean check(String apiKey);
}
