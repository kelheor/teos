package com.academy.teos.service.impl;

import com.academy.teos.converter.UserAccountConverter;
import com.academy.teos.dao.UserAccountDAO;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.entity.UserAccount;
import com.academy.teos.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
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
    public UserAccountDTO persist(UserAccountDTO userAccountDTO) throws Exception {

        UserAccount userAccount = UserAccountConverter.convertToUserAccount(userAccountDTO);

        if (userAccount.getUsername() == null) {
            throw new IllegalArgumentException("Username can't be null");
        }

        if (userAccount.getPassword() == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(userAccount.getPassword().getBytes());
        byte byteData[] = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        userAccount.setPassword(sb.toString());

        UserAccount existingUserAccountDTO = userAccountDAO.findUserByUsername(userAccount.getUsername());

        if(existingUserAccountDTO != null) {
            throw new Exception("Пользователь с таким именем уже существует");
        }

        userAccount = userAccountDAO.persist(userAccount);

        return UserAccountConverter.convertToUserAccountDTO(userAccount);
    }

    @Override
    public UserAccountDTO get(String id) {
        return UserAccountConverter.convertToUserAccountDTO(userAccountDAO.get(id));
    }

    @Override
    public UserAccountDTO merge(UserAccountDTO userAccountDTO) throws Exception {

        UserAccount userAccount = UserAccountConverter.convertToUserAccount(userAccountDTO);

        if (userAccount.getPassword() != null) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(userAccount.getPassword().getBytes());
            byte byteData[] = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            userAccount.setPassword(sb.toString());
        } else {
            UserAccount oldUserAccount = userAccountDAO.get(userAccount.getUserAccountId());
            userAccount.setPassword(oldUserAccount.getPassword());
        }


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
    public ArrayList<UserAccountDTO> persist(List<UserAccountDTO> userAccountDTOList) throws Exception {
        ArrayList<UserAccountDTO> resultList = new ArrayList<UserAccountDTO>();

        for (UserAccountDTO userAccountDTO : userAccountDTOList) {
            userAccountDTO = persist(userAccountDTO);
            resultList.add(userAccountDTO);
        }

        return resultList;
    }

    @Override
    public ArrayList<UserAccountDTO> merge(List<UserAccountDTO> userAccountDTOList) throws Exception {
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
