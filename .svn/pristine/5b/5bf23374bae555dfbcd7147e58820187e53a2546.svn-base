package org.szd.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szd.base.entity.BaseRole;
import org.szd.base.service.BaseRoleService;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.util.MyBeanUtils;

import redis.RedisUtil;

@Service
public class BaseRoleServiceImpl extends BaseServiceImpl<BaseRole> implements BaseRoleService{
	
	protected Logger logger = LoggerFactory.getLogger(BaseRoleServiceImpl.class);
	
	public static String preKey="base_BaseRole_roleCode_";
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseRoleDao")  
   public void setDao(BaseDao<BaseRole> dao) {
       super.setDao(dao);  
   }
   
   @Autowired
   private RedisUtil redisUtil;

	@Override
	public void initCache() {
		List<BaseRole> list=findAll();
		int i=0;
		for(BaseRole baseRole:list){
			i=i+1;
			Map<String, Object> beanMap=MyBeanUtils.introspect(baseRole);
			String hashKey=preKey+baseRole.getRoleCode();
			redisUtil.setHashValue(hashKey, beanMap);
			logger.info("========baseRole-init:"+i+"/"+list.size()+"==================");
		}
	}

	@Override
	public Page findPage(BaseRole baseRole, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseRole::findPage", pageNo, pageSize, values);
	}

	@Override
	public void cacheOne(BaseRole baseRole) {
		Map<String, Object> beanMap=MyBeanUtils.introspect(baseRole);
		String hashKey=preKey+baseRole.getRoleCode();
		redisUtil.setHashValue(hashKey, beanMap);
	}
	
	@Override
	public void delCacheOne(String roleCode) {
		String hashKey=preKey+roleCode;
		redisUtil.delete(hashKey);
	}
   
}
