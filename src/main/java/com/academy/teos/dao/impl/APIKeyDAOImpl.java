package com.academy.teos.dao.impl;

import com.academy.teos.dao.APIKeyDAO;
import com.academy.teos.entity.APIKey;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: Kelheor
 */
@Repository
@Configurable
public class APIKeyDAOImpl extends BaseDAOImpl implements APIKeyDAO {

    public static final Logger LOG = Logger.getLogger(APIKeyDAOImpl.class);

    public boolean check(String apiKey) {
        TypedQuery<APIKey> q = getEntityManager().createQuery("SELECT o FROM APIKey o WHERE o.apiKey = :apiKey ", APIKey.class);
        q.setParameter("apiKey", apiKey);
        List<APIKey> userAccountList = q.getResultList();
        if(userAccountList != null && userAccountList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public APIKeyDAOImpl() {
        super(APIKey.class);
    }

    public APIKey persist(APIKey o) {
        return (APIKey) super.persist(o);
    }

    public APIKey get(String id) {
        return (APIKey) super.get(id);
    }

    public APIKey merge(APIKey o) {
        return (APIKey) super.merge(o);
    }

    public void delete(APIKey o) {
        super.delete(o);
    }
}
