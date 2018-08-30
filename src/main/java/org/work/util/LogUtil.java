package org.work.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {
	
	private static Logger logger = LoggerFactory.getLogger(LogUtil.class);
	
	public static void info(Map<String,Object> message){
		StringBuffer sb =new StringBuffer();
		for (Map.Entry<String,Object> entry : message.entrySet()) {
			if(sb.length()==0){
				sb.append(entry.getKey()+"="+entry.getValue());
			}else{
				sb.append(" "+entry.getKey()+"="+entry.getValue());
			}
		}
		logger.info(sb.toString());
	}
	
	public static void main(String[] args) {
		Map<String,Object> message = new HashMap<String,Object>();
		message.put("className", "tttttttttt");
		message.put("doMethod", "test");
		LogUtil.info(message);
	}
}