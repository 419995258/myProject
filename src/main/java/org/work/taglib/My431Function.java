package org.work.taglib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.szd.base.entity.BaseProperties;
import org.szd.base.entity.BaseUrl;
import org.work.util.DateFormater;
import org.work.util.MD5;
import org.work.util.SpringContextUtil;

import redis.RedisUtil;

public class My431Function {
	private static String preRoleMapKey = "global.base.BaseRole.map.key.";
	private static String prePropertiesMapKey = "global.base.BaseProperties.key.";
	public static String listPreKey = "global.base.BaseUrl.key.id.";// 模块对应url的list
	public static String urlObjectKey = "global.base.BaseUrl.key.urlId.";// 单独一个baseurl
	public static String schoolUserPreKey = "global.base.BaseUser.schoolId.";
	public static String urlPreKey="global.base.BaseUrl.key.url.";

	/**
	 * 功能描述 ：传入属性值，得到属性值。<br>
	 * */
	public static String getValueByCode(String code) {
		if (code != null && !code.trim().equals("")) {
			RedisUtil redisUtil =(RedisUtil) SpringContextUtil.getBean("redisUtil");
			Object v = redisUtil.get(prePropertiesMapKey + code);
			if (v != null) {
				return ((BaseProperties) v).getPropertyValue();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static BaseUrl getObjByUrl(String url){
		RedisUtil redisUtil =(RedisUtil) SpringContextUtil.getBean("redisUtil");
		if(redisUtil.hasKey(urlPreKey+MD5.getMd5(url))){
			Object o=redisUtil.get(urlPreKey+MD5.getMd5(url));
			if(o!=null){
				return (BaseUrl)o;
			}else{
				return null;
			}
			
		}else{
			return null;
		}
	}
	
	public static String UTC(String date){
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
		df2.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date ndt;
		try {
			ndt = df2.parse(date);
			return DateFormater.DateToString(ndt, "yyyy-MM-dd HH:mm:ss:S");
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		
	}
			
}
