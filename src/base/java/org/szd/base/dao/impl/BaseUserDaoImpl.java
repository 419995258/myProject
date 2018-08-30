/*
 * wangzhen
 * date 2017
 */

package org.szd.base.dao.impl;

import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */


import org.springframework.stereotype.Repository;
import org.szd.base.dao.BaseUserDao;
import org.szd.base.entity.BaseUser;
import org.work.platform.dao.impl.BaseDaoImpl;

@Repository(value = "baseUserDao") 
public class BaseUserDaoImpl extends BaseDaoImpl<BaseUser> implements BaseUserDao{

}
