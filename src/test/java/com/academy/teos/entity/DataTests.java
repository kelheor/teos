package com.academy.teos.entity;

import com.academy.teos.dao.DataDAO;
import com.academy.teos.dto.DataDTO;
import com.academy.teos.dto.list.DataDTOList;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @author: Руслан
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext_test.xml"})
public class DataTests {

    public static final Logger LOG = Logger.getLogger(DataTests.class);

    @Autowired
    private DataDAO dataDAO;

    @org.junit.Test
    public void testEntityCreate() {
        try {
            Data data = new Data();
            data.setData("Test".getBytes());

            data = dataDAO.persist(data);

            Data savedData = dataDAO.get(data.getId());
            LOG.info(new String(savedData.getData(), "UTF-8"));
        } catch (Exception e) {
            LOG.error("Error testEntityCreate: " + e.getMessage(), e);
        }

    }

    @org.junit.Test
    public void testJSONToDataDTOList() {
        try {
           String dataList = "[{\"id\": \"test\", \"data\": \"null\"}]";
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<DataDTO> dataDTOArrayList = mapper.readValue(dataList, DataDTOList.class);
            for (DataDTO dataDTO : dataDTOArrayList) {
                LOG.info(dataDTO.getId());
            }
        } catch (Exception e) {
            LOG.error("Error testJSONToDataDTOList: " + e.getMessage(), e);
        }

    }
}
