package com.academy.teos.controller;

import com.academy.teos.controller.utils.Ajax;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.dto.list.UserAccountDTOList;
import com.academy.teos.service.UserAccountService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/controller/userAccount")
public class UserAccountController extends ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccountController.class);

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/edit_profile", method = RequestMethod.GET)
    public String edit_profile() {
        return "edit_profile";
    }

    @RequestMapping(value = "/show_profile", method = RequestMethod.GET)
    public String show_profile() {
        return "show_profile";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persist(String userAccount) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountDTO = userAccountService.persist(userAccountDTO);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/persistList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persistList(String userAccountList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountDTOs = userAccountService.persist(userAccountDTOs);
            return Ajax.successResponse(userAccountDTOs);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> get(String id) {
        try {
            UserAccountDTO userAccountDTO = userAccountService.get(id);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> merge(String userAccount) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountDTO = userAccountService.merge(userAccountDTO);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/mergeList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> mergeList(String userAccountList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountDTOs = userAccountService.merge(userAccountDTOs);
            return Ajax.successResponse(userAccountDTOs);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> delete(String userAccount) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountService.delete(userAccountDTO);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> deleteList(String userAccountList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<UserAccountDTO> userAccountDTOs = mapper.readValue(userAccountList, UserAccountDTOList.class);
            userAccountService.delete(userAccountDTOs);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }
}
