package com.academy.teos.controller;

import com.academy.teos.controller.utils.Ajax;
import com.academy.teos.controller.utils.RestException;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.dto.list.UserAccountDTOList;
import com.academy.teos.service.APIKeyService;
import com.academy.teos.service.UserAccountService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author: Kelheor
 */
@Controller
@RequestMapping("/api/userAccount")
public class UserAccountController extends ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(UserAccountController.class);

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private APIKeyService apiKeyService;


    @RequestMapping(value = "/persist", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persist(String APIKey, String userAccount) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountDTO = userAccountService.persist(userAccountDTO);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/persistList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persistList(String APIKey, String userAccountList) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountDTOs = userAccountService.persist(userAccountDTOs);
            return Ajax.successResponse(userAccountDTOs);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> get(String APIKey, String id) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            UserAccountDTO userAccountDTO = userAccountService.get(id);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> merge(String APIKey, String userAccount) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountDTO = userAccountService.merge(userAccountDTO);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/mergeList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> mergeList(String APIKey, String userAccountList) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountDTOs = userAccountService.merge(userAccountDTOs);
            return Ajax.successResponse(userAccountDTOs);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> delete(String APIKey, String userAccount) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountService.delete(userAccountDTO);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> deleteList(String APIKey, String userAccountList) throws RestException {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountService.delete(userAccountDTOs);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
}
