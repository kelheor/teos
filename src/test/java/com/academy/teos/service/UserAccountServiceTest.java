package com.academy.teos.service;

import com.academy.teos.dto.UserAccountDTO;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Kelheor
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext_test.xml"})
public class UserAccountServiceTest {

    public static final Logger LOG = Logger.getLogger(UserAccountServiceTest.class);

    @Autowired
    private UserAccountService userAccountService;

    @org.junit.Test
    public void testMergeAndFind() {
        try {
            UserAccountDTO userAccountDTO = new UserAccountDTO();
            userAccountDTO.setUsername("root");
            userAccountDTO.setPassword("12345");

            userAccountDTO = userAccountService.merge(userAccountDTO);

            LOG.info("userAccountDTO Id: " + userAccountDTO.getUserAccountId());

            UserAccountDTO findedUserAccountDTO = userAccountService.findUserByUsernameAndPassword("root", "12345");

            Assert.assertNotNull(findedUserAccountDTO);

            LOG.info("finded userAccountDTO Id: " + findedUserAccountDTO.getUserAccountId());

        } catch (Exception e) {
            LOG.error("Error testMergeAndFind: " + e.getMessage(), e);
        }

    }
}
