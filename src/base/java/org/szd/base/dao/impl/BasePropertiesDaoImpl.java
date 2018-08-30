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
import org.szd.base.dao.BasePropertiesDao;
import org.szd.base.entity.BaseProperties;
import org.work.platform.dao.impl.BaseDaoImpl;

@Repository(value = "basePropertiesDao") 
public class BasePropertiesDaoImpl extends BaseDaoImpl<BaseProperties> implements BasePropertiesDao{

}
