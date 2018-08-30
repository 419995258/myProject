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
import org.szd.base.dao.BaseUrlDao;
import org.szd.base.entity.BaseUrl;
import org.work.platform.dao.impl.BaseDaoImpl;

@Repository(value = "baseUrlDao") 
public class BaseUrlDaoImpl extends BaseDaoImpl<BaseUrl> implements BaseUrlDao{

}
