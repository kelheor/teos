package com.academy.teos.service;

import com.academy.teos.dto.UserAccountDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelheor
 */
public interface UserAccountService {

    public UserAccountDTO findUserByUsernameAndPassword(String username, String password);

    public UserAccountDTO persist(UserAccountDTO userAccountDTO) throws Exception;

    public ArrayList<UserAccountDTO> persist(List<UserAccountDTO> userAccountDTOList) throws Exception;

    public UserAccountDTO get(String id);

    public UserAccountDTO merge(UserAccountDTO userAccountDTO) throws Exception;

    public ArrayList<UserAccountDTO> merge(List<UserAccountDTO> userAccountDTOList) throws Exception;

    public void delete(UserAccountDTO userAccountDTO);

    public void delete(List<UserAccountDTO> userAccountDTOList);

}
