package com.academy.teos.service.impl;

import com.academy.teos.converter.UserAccountConverter;
import com.academy.teos.dao.UserAccountDAO;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.entity.UserAccount;
import com.academy.teos.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelheor
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    @Autowired
    private UserAccountDAO userAccountDAO;

    @Override
    public UserAccountDTO findUserByUsernameAndPassword(String username, String password) {
        UserAccount userAccount = userAccountDAO.findUserAccountByUsernameAndPassword(username, password);
        if (userAccount == null) {
            return null;
        }
        if (userAccount.getUsername() == null && userAccount.getPassword() == null) {
            return null;
        }
        return UserAccountConverter.convertToUserAccountDTO(userAccount);
    }

    @Override
    public UserAccountDTO persist(UserAccountDTO userAccountDTO) {

        UserAccount userAccount = UserAccountConverter.convertToUserAccount(userAccountDTO);

        if (userAccount.getUsername() == null) {
            throw new IllegalArgumentException("Username can't be null");
        }

        if (userAccount.getPassword() == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        userAccount = userAccountDAO.persist(userAccount);

        return UserAccountConverter.convertToUserAccountDTO(userAccount);
    }

    @Override
    public UserAccountDTO get(String id) {
        return UserAccountConverter.convertToUserAccountDTO(userAccountDAO.get(id));
    }

    @Override
    public UserAccountDTO merge(UserAccountDTO userAccountDTO) {

        UserAccount userAccount = UserAccountConverter.convertToUserAccount(userAccountDTO);

        if (userAccount.getUsername() == null) {
            throw new IllegalArgumentException("Username can't be null");
        }

        if (userAccount.getPassword() == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        userAccount = userAccountDAO.merge(userAccount);

        return UserAccountConverter.convertToUserAccountDTO(userAccount);
    }

    @Override
    public void delete(UserAccountDTO userAccountDTO) {
        userAccountDAO.delete(UserAccountConverter.convertToUserAccount(userAccountDTO));
    }

    @Override
    public ArrayList<UserAccountDTO> persist(List<UserAccountDTO> userAccountDTOList) {
        ArrayList<UserAccountDTO> resultList = new ArrayList<UserAccountDTO>();

        for (UserAccountDTO userAccountDTO : userAccountDTOList) {
            userAccountDTO = persist(userAccountDTO);
            resultList.add(userAccountDTO);
        }

        return resultList;
    }

    @Override
    public ArrayList<UserAccountDTO> merge(List<UserAccountDTO> userAccountDTOList) {
        ArrayList<UserAccountDTO> resultList = new ArrayList<UserAccountDTO>();

        for (UserAccountDTO userAccountDTO : userAccountDTOList) {
            userAccountDTO = merge(userAccountDTO);
            resultList.add(userAccountDTO);
        }

        return resultList;
    }

    @Override
    public void delete(List<UserAccountDTO> userAccountDTOList) {
        for (UserAccountDTO userAccountDTO : userAccountDTOList) {
            delete(userAccountDTO);
        }
    }
}
