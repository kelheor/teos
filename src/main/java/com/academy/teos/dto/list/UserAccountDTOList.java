package com.academy.teos.dto.list;

import com.academy.teos.entity.UserAccount;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.ArrayList;

/**
 * @author: Kelheor
 */
@JsonDeserialize(contentAs = UserAccount.class)
public class UserAccountDTOList extends ArrayList<UserAccount> {
}
