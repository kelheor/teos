package com.academy.teos.dto.list;

import com.academy.teos.dto.DataDTO;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.ArrayList;

/**
 * @author: Kelheor
 */
@JsonDeserialize(contentAs = DataDTO.class)
public class DataDTOList extends ArrayList<DataDTO> {
}
