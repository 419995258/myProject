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
import org.szd.base.dao.BaseNoteDao;
import org.szd.base.entity.BaseNote;
import org.work.platform.dao.impl.BaseDaoImpl;

@Repository(value = "baseNoteDao") 
public class BaseNoteDaoImpl extends BaseDaoImpl<BaseNote> implements BaseNoteDao{

}
