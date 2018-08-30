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
import org.szd.base.dao.BaseModuleDao;
import org.szd.base.entity.BaseModule;
import org.work.platform.dao.impl.BaseDaoImpl;

@Repository(value = "baseModuleDao") 
public class BaseModuleDaoImpl extends BaseDaoImpl<BaseModule> implements BaseModuleDao{

}
