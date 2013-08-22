package com.academy.teos.controller;

import com.academy.teos.controller.utils.Ajax;
import com.academy.teos.dto.DataDTO;
import com.academy.teos.dto.list.DataDTOList;
import com.academy.teos.service.APIKeyService;
import com.academy.teos.service.DataService;
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
@RequestMapping("/api/data")
public class DataController {

    private static final Logger LOG = Logger.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    @Autowired
    private APIKeyService apiKeyService;

    @RequestMapping(value = "/persist", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persist(String APIKey, String data) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            DataDTO dataDTO = mapper.readValue(data, DataDTO.class);
            dataDTO = dataService.persist(dataDTO);
            return Ajax.successResponse(dataDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/persistList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> persistList(String APIKey, String dataList) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<DataDTO> dataDTOs = mapper.readValue(dataList, DataDTOList.class);
            dataDTOs = dataService.persist(dataDTOs);
            return Ajax.successResponse(dataDTOs);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> get(String APIKey, String id) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            DataDTO dataDTO = dataService.get(id);
            return Ajax.successResponse(dataDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> merge(String APIKey, String data) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            DataDTO dataDTO = mapper.readValue(data, DataDTO.class);
            dataDTO = dataService.merge(dataDTO);
            return Ajax.successResponse(dataDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/mergeList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> mergeList(String APIKey, String dataList) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<DataDTO> dataDTOs = mapper.readValue(dataList, DataDTOList.class);
            dataDTOs = dataService.merge(dataDTOs);
            return Ajax.successResponse(dataDTOs);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> delete(String APIKey, String data) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            DataDTO dataDTO = mapper.readValue(data, DataDTO.class);
            dataService.delete(dataDTO);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> deleteList(String APIKey, String dataList) {
        try {
            if(!apiKeyService.check(APIKey)) {
                return Ajax.errorResponse("Wrong API key");
            }
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<DataDTO> dataDTOs = mapper.readValue(dataList, DataDTOList.class);
            dataService.delete(dataDTOs);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
    }
}
