package com.academy.teos.service;

import com.academy.teos.dto.UserAccountDTO;

import java.util.List;

/**
 * @author: Kelheor
 */
public interface UserAccountService {

    public UserAccountDTO findUserByUsernameAndPassword(String username, String password);

    public UserAccountDTO persist(UserAccountDTO userAccountDTO);

    public List<UserAccountDTO> persist(List<UserAccountDTO> userAccountDTOList);

    public UserAccountDTO get(String id);

    public UserAccountDTO merge(UserAccountDTO userAccountDTO);

    public List<UserAccountDTO> merge(List<UserAccountDTO> userAccountDTOList);

    public void delete(UserAccountDTO userAccountDTO);

    public void delete(List<UserAccountDTO> userAccountDTOList);

}
