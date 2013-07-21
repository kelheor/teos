package com.academy.teos.service;

import com.academy.teos.dto.DataDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelheor
 */
public interface DataService {

    public DataDTO persist(DataDTO dataDTO);

    public ArrayList<DataDTO> persist(List<DataDTO> dataDTOList);

    public DataDTO get(String id);

    public DataDTO merge(DataDTO dataDTO);

    public ArrayList<DataDTO> merge(List<DataDTO> dataDTOList);

    public void delete(DataDTO dataDTO);

    public void delete(List<DataDTO> dataDTOList);
}
