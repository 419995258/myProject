package org.szd.base.service.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.szd.base.service.BaseQueryService;

@Service
public class InitListener implements ApplicationListener<ContextRefreshedEvent>{
	protected Logger logger = LoggerFactory.getLogger(InitListener.class);
	
	@Autowired
	private BaseQueryService baseQueryService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		 if(event.getApplicationContext().getParent() == null){
			 logger.info("============================== begin init========================");
			 baseQueryService.initCache();
			 logger.info("============================== end init========================");
        }
	}


}
