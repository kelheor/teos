package com.academy.teos.dao.impl;

import com.academy.teos.dao.UserAccountDAO;
import com.academy.teos.entity.UserAccount;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: Kelheor
 */
@Repository
@Configurable
public class UserAccountDAOImpl extends BaseDAOImpl implements UserAccountDAO {

    public static final Logger LOG = Logger.getLogger(UserAccountDAOImpl.class);

    public static final EntityManager entityManager() {
        EntityManager em = new UserAccountDAOImpl().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public UserAccount findUserAccountByUsernameAndPassword(String username, String password) {
        TypedQuery<UserAccount> q = entityManager().createQuery("SELECT o FROM UserAccount o WHERE o.username = :username AND o.password = :password ", UserAccount.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        List<UserAccount> userAccountList = q.getResultList();
        if(userAccountList != null && userAccountList.size() > 0) {
            return userAccountList.get(0);
        } else {
            return null;
        }
    }

    public UserAccountDAOImpl() {
        super(UserAccount.class);
    }

    public UserAccount persist(UserAccount o) {
        return (UserAccount) super.persist(o);
    }

    public UserAccount get(String id) {
        return (UserAccount) super.get(id);
    }

    public UserAccount merge(UserAccount o) {
        return (UserAccount) super.merge(o);
    }

    public void delete(UserAccount o) {
        super.delete(o);
    }
}