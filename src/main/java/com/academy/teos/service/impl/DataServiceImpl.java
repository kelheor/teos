package com.academy.teos.service.impl;

import com.academy.teos.converter.DataConverter;
import com.academy.teos.dao.DataDAO;
import com.academy.teos.dto.DataDTO;
import com.academy.teos.entity.Data;
import com.academy.teos.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelheor
 */
@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    private DataDAO dataDAO;

    @Override
    public DataDTO persist(DataDTO dataDTO) {

        Data data = DataConverter.convertToData(dataDTO);

        if (data.getData() == null) {
            throw new IllegalArgumentException("Data can't be null");
        }

        data = dataDAO.persist(data);

        return DataConverter.convertToDataDTO(data);
    }

    @Override
    public DataDTO get(String id) {
        return DataConverter.convertToDataDTO(dataDAO.get(id));
    }

    @Override
    public DataDTO merge(DataDTO dataDTO) {

        Data data = DataConverter.convertToData(dataDTO);

        if (data.getData() == null) {
            throw new IllegalArgumentException("Data can't be null");
        }

        data = dataDAO.merge(data);

        return DataConverter.convertToDataDTO(data);
    }

    @Override
    public void delete(DataDTO dataDTO) {
        dataDAO.delete(DataConverter.convertToData(dataDTO));
    }

    @Override
    public ArrayList<DataDTO> persist(List<DataDTO> dataDTOList) {
        ArrayList<DataDTO> resultList = new ArrayList<DataDTO>();

        for (DataDTO dataDTO : dataDTOList) {
            dataDTO = persist(dataDTO);
            resultList.add(dataDTO);
        }

        return resultList;
    }

    @Override
    public ArrayList<DataDTO> merge(List<DataDTO> dataDTOList) {
        ArrayList<DataDTO> resultList = new ArrayList<DataDTO>();

        for (DataDTO dataDTO : dataDTOList) {
            dataDTO = merge(dataDTO);
            resultList.add(dataDTO);
        }

        return resultList;
    }

    @Override
    public void delete(List<DataDTO> dataDTOList) {
        for (DataDTO dataDTO : dataDTOList) {
            delete(dataDTO);
        }
    }
}
