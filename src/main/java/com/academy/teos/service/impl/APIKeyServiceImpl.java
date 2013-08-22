package com.academy.teos.service.impl;

import com.academy.teos.dao.APIKeyDAO;
import com.academy.teos.service.APIKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Kelheor
 */
@Service("apiKeyService")
public class APIKeyServiceImpl implements APIKeyService {

    private static final Logger LOG = LoggerFactory.getLogger(APIKeyServiceImpl.class);

    @Autowired
    private APIKeyDAO apiKeyDAO;

    @Override
    public boolean check(String APIKey) throws Exception {
        return apiKeyDAO.check(APIKey);
    }
}
