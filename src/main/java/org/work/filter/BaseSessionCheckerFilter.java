package org.work.filter;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.szd.base.entity.BaseProperties;
import org.szd.base.entity.BaseUrl;
import org.work.listener.OnlineModel;
import org.work.taglib.My431Function;
import org.work.util.DateFormater;
import org.work.util.LogUtil;
import org.work.util.MD5;
import org.work.util.SpringContextUtil;

import redis.RedisUtil;



public class BaseSessionCheckerFilter implements Filter {
	private static String urlPreKey="global.base.BaseUrl.key.url.";
	private static String prePropertiesMapKey = "global.base.BaseProperties.key.";
	private static String listPreKey="global.base.BaseRoleUrlMap.key.id.";

	private Log log = LogFactory.getLog(BaseSessionCheckerFilter.class);

	protected FilterConfig filterConfig = null;
	

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession theSession = ((HttpServletRequest) request).getSession(true);
		HttpServletResponse theResponse=((HttpServletResponse) response);
		HttpServletRequest theRequest=((HttpServletRequest) request);
      
		
		Integer port= request.getServerPort();
		
		if(theSession.getAttribute("wsLoginName")==null){
			theSession.invalidate();
			if(port==80){
				theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+theRequest.getContextPath()+"/login.jsp");
			}else{
				theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+theRequest.getContextPath()+"/login.jsp");
			}
			return;
		}else{
			String isAuthenticatedUrl=My431Function.getValueByCode("isAuthenticatedUrl");
			
			Map<String,Object> logMessage = new HashMap<String,Object>();
			
			logMessage.put("dologinName", theSession.getAttribute("wsLoginName"));
			logMessage.put("doRealName", theSession.getAttribute("wsRealName"));
			logMessage.put("isAuthenticatedUrl", isAuthenticatedUrl);
			
			String path=theRequest.getServletPath();
			
			String[] paths=path.split("/");
			
			if(paths!=null){
				String doMethod=paths[paths.length-1];
				String className=paths[paths.length-2];
				
				logMessage.put("className", className);
				logMessage.put("doMethod", doMethod);
			}
			
			String ext="";
			if(path.lastIndexOf(".")==-1){
				
			}else{
				ext=path.substring(path.lastIndexOf("."), path.length());
			}
			
			Enumeration<String> ks = ((HttpServletRequest) request).getParameterNames();
			while (ks.hasMoreElements()) {//循环遍历Header中的参数，把遍历出来的参数放入Map中
				String key=ks.nextElement();
                String value=((HttpServletRequest) request).getParameter(key);
                logMessage.put(key, value);
            }
			
			RedisUtil redisUtil =(RedisUtil) SpringContextUtil.getBean("redisUtil");
			
				if(isAuthenticatedUrl!=null&&isAuthenticatedUrl.equals("1")){
					String wsDefaultRoleCode=theSession.getAttribute("wsDefaultRoleCode").toString();
					if(wsDefaultRoleCode!=null){
						BaseUrl url=getObjByUrl(path,redisUtil);
						boolean ispass=true;
						if(url==null){
							ispass=false;
						}else{
							Object obj=theSession.getAttribute("logined");
							Object objUserId=theSession.getAttribute("wsuserId");
							OnlineModel  onlineModel=new OnlineModel();
							String userId="";
							if(obj!=null){
								onlineModel=(OnlineModel) obj;
							}
							if(objUserId!=null){
								userId=(String) objUserId;
							}
							if(!isPass(wsDefaultRoleCode, url,redisUtil)){
								ispass=false;
							}
						}
						if(ispass){
							logMessage.put("urlAuthStatus", "1");
							LogUtil.info(logMessage);
							chain.doFilter(request, response);
							return;
						}else{
							logMessage.put("urlAuthStatus", "-1");
							LogUtil.info(logMessage);
							if(port==80){
								theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+theRequest.getContextPath()+"/url_error.jsp?path="+URLEncoder.encode(path,"utf-8"));
							}else{
								theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+theRequest.getContextPath()+"/url_error.jsp?path="+URLEncoder.encode(path,"utf-8"));
							}
							
							return;
						}
						
					}else{
						
						if(port==80){
							theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+theRequest.getContextPath()+"/url_error.jsp?path="+URLEncoder.encode(path,"utf-8"));
						}else{
							theResponse.sendRedirect(theRequest.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+theRequest.getContextPath()+"/url_error.jsp?path="+URLEncoder.encode(path,"utf-8"));
						}
						
						return;
					}

				}else{
					logMessage.put("urlAuthStatus", "1");
					LogUtil.info(logMessage);
					chain.doFilter(request, response);
					return;
				}
			
		
		}

	}
	
	public String getValueByCode(String code,RedisUtil redisUtil) {
		if (code != null && !code.trim().equals("")) {
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
	
	public BaseUrl getObjByUrl(String url,RedisUtil redisUtil){
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
	
	public Boolean isPass(String roleCode,BaseUrl url,RedisUtil redisUtil){
		Boolean ispass=false;
		if(url!=null&&redisUtil.hasKey(listPreKey+roleCode+url.getUrl())){
			if(redisUtil.get(listPreKey+roleCode+url.getUrl())!=null){
				if(redisUtil.get(listPreKey+roleCode+url.getUrl()).equals(1)){
					ispass=true;
				}
			}
		}
		return ispass;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
}