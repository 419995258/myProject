package org.szd.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szd.base.entity.BaseQuery;
import org.szd.base.service.BaseQueryService;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.util.MyBeanUtils;

import redis.RedisUtil;

@Service
public class BaseQueryServiceImpl extends BaseServiceImpl<BaseQuery> implements BaseQueryService{
	private static Logger logger = LoggerFactory.getLogger(BaseQueryServiceImpl.class);
	
	public static String preKey="base_BaseQuery_queryName_";
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseQueryDao")  
   public void setDao(BaseDao<BaseQuery> dao) {
       super.setDao(dao);  
   }
   
   @Autowired
   private RedisUtil redisUtil;

	@Override
	public void initCache() {
		List<BaseQuery> list=findAll();
		int i=0;
		for(BaseQuery baseQuery:list){
			i=i+1;
			Map<String, Object> beanMap=MyBeanUtils.introspect(baseQuery);
			String hashKey=preKey+baseQuery.getQueryName();
			redisUtil.setHashValue(hashKey, beanMap);
			logger.debug("========BaseQuery-init:"+i+"/"+list.size()+"==================");
		}
	}

	@Override
	public Page findPage(BaseQuery query, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseQuery::findPage", pageNo, pageSize, values);
	}

	@Override
	public void cacheOne(BaseQuery baseQuery) {
		Map<String, Object> beanMap=MyBeanUtils.introspect(baseQuery);
		String hashKey=preKey+baseQuery.getQueryName();
		redisUtil.setHashValue(hashKey, beanMap);
	}
	
	@Override
	public void delCacheOne(String queryName) {
		String hashKey=preKey+queryName;
		redisUtil.delete(hashKey);
	}
   
}
