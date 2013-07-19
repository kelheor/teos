package com.academy.teos.dao;

import com.academy.teos.entity.UserAccount;

/**
 * @author: Kelheor
 */
public interface UserAccountDAO extends BaseDAO {

    public UserAccount persist(UserAccount o);

    public UserAccount get(String id);

    public UserAccount update(UserAccount o);

    public void delete(UserAccount o);
}