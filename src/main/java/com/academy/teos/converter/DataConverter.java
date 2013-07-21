package com.academy.teos.converter;

import com.academy.teos.dto.DataDTO;
import com.academy.teos.entity.Data;

/**
 * @author: Kelheor
 */
public class DataConverter {

    public static DataDTO convertToDataDTO(Data data) {
        DataDTO dataDTO = new DataDTO();
        dataDTO.setData(data.getData());
        dataDTO.setId(data.getId());
        return dataDTO;
    }

    public static Data convertToData(DataDTO dataDTO) {
        Data data = new Data();
        data.setData(dataDTO.getData());
        data.setId(dataDTO.getId());
        return data;
    }
}
