package com.academy.teos.service;

import com.academy.teos.dto.UserAccountDTO;

/**
 * @author: Kelheor
 */
public interface UserAccountService {

    public UserAccountDTO findUserByUsernameAndPassword(String username, String password);

}
