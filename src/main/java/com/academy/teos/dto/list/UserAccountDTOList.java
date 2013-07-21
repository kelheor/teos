package com.academy.teos.dto.list;

import com.academy.teos.dto.UserAccountDTO;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.ArrayList;

/**
 * @author: Kelheor
 */
@JsonDeserialize(contentAs = UserAccountDTO.class)
public class UserAccountDTOList extends ArrayList<UserAccountDTO> {
}
