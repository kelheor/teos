package com.academy.teos.service.impl;

import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.service.UserAccountService;
import org.springframework.stereotype.Service;

/**
 * @author: Kelheor
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    @Override
    public UserAccountDTO findUserByUsernameAndPassword(String username, String password) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
