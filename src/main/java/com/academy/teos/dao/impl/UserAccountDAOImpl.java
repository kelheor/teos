package com.academy.teos.dao.impl;

import com.academy.teos.dao.UserAccountDAO;
import com.academy.teos.entity.UserAccount;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author: Kelheor
 */
@Repository
public class UserAccountDAOImpl extends BaseDAOImpl implements UserAccountDAO {

    public static final Logger LOG = Logger.getLogger(UserAccountDAOImpl.class);

    public UserAccountDAOImpl() {
        super(UserAccount.class);
    }

    public UserAccount persist(UserAccount o) {
        return (UserAccount) super.persist(o);
    }

    public UserAccount get(String id) {
        return (UserAccount) super.get(id);
    }

    public UserAccount update(UserAccount o) {
        return (UserAccount) super.update(o);
    }

    public void delete(UserAccount o) {
        super.delete(o);
    }
}