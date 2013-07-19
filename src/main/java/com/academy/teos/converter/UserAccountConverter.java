package com.academy.teos.converter;

import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.entity.UserAccount;

/**
 * @author: Kelheor
 */
public class UserAccountConverter {

    public UserAccountDTO convertToUserAccountDTO(UserAccount userAccount) {
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setPassword(userAccount.getPassword());
        userAccountDTO.setUsername(userAccount.getUsername());
        userAccountDTO.setUserAccountId(userAccount.getUserAccountId());
        return userAccountDTO;
    }

    public UserAccount convertToUserAccount(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setPassword(userAccountDTO.getPassword());
        userAccount.setUsername(userAccountDTO.getUsername());
        userAccount.setUserAccountId(userAccountDTO.getUserAccountId());
        return userAccount;
    }
}
