package org.szd.base.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.LifecycleUtils;
import org.apache.shiro.util.SoftHashMap;
import org.apache.shiro.web.tags.HasPermissionTag;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.szd.base.entity.BaseUser;
import org.work.util.MD5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "base/Shiro")
public class ShiroController {


//    @Autowired
//    private MemoryConstrainedCacheManager shiroCacheManager;

    @Autowired
    private CacheManager shiroCacheManager;

    @RequestMapping(value="/doShiroLogin",method= RequestMethod.POST)
    @ResponseBody
    public String doShiroLogin(@RequestBody BaseUser user, HttpServletRequest request){
        String msg = null;//
        user = (BaseUser) request.getSession().getAttribute("wsBaseUser");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);//登录
            if (subject.isAuthenticated()) {
                Object name = SecurityUtils.getSubject().getPrincipals();
//                new SimpleAuthenticationInfo(user,user.getPassword(),user.getLoginName());
//                Set<String> roles = new HashSet<>();
//                Iterator<String> roleIterator=roles.iterator();
//                boolean flag=false;
//                while(roleIterator.hasNext()) {
//                    if (subject.hasRole(roleIterator.next())) {
//                        roles.add(subject)
//                    }
//                }
                if (subject.hasRole("role.admin")){
                    System.out.println("ok");
                }
                if(subject.isPermitted("create")){
                    System.out.println("ok");
                }
            }else{
                System.out.println("no");
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            System.out.println(msg);
        }
        return "success";
    }


    @RequestMapping(value="/ShiroDemoPermission",method= RequestMethod.GET)
//    权限为create和query
    @RequiresPermissions(value={"create","query"}, logical= Logical.OR)
    @ResponseBody
    public void ShiroDemoPermission(){
        System.out.println("权限为create或者query");
    }

    @RequestMapping(value="/ShiroDemoPermission2",method= RequestMethod.GET)
    @RequiresPermissions("other")
    @ResponseBody
    public void ShiroDemoPermission2(){
        System.out.println("权限为other");
    }

    @RequestMapping(value="/ShiroDemoRole",method= RequestMethod.GET)
    //    角色为admin或者test
    @RequiresRoles(value={"role.admin","role.test"}, logical= Logical.OR)
    @ResponseBody
    public void ShiroDemoRole(){
        System.out.println("角色为：role.admin或者role.test");
    }

    @RequestMapping(value="/ShiroDemoRole2",method= RequestMethod.GET)
    @RequiresRoles("role.test")
    @ResponseBody
    public void ShiroDemoRole2(){
        //Cache<Object, Object> cache  = shiroCacheManager.getCache();
        System.out.println("角色为：role.test");
    }

    @RequestMapping(value="/clearShiroCatch",method= RequestMethod.GET)
    @ResponseBody
    public void clearShiroCatch(){
        //获取权限看一下
        /*
        /*  @Autowired
            private CacheManager shiroCacheManager;
        */
        Cache<Object, Object> cache  = shiroCacheManager.getCache("org.apache.shiro.realm.jdbc.JdbcRealm.authorizationCache");
//        shiroCacheManager.destroy();//清除全部缓存
//        LifecycleUtils.destroy(cache);//清除某个缓存
        Subject subject = SecurityUtils.getSubject();
        /*subject.getPrincipal()------>登录名
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户名,想要操作权限的用户，第二个参数为realmName,
        SimplePrincipalCollection principals = new SimplePrincipalCollection(subject.getPrincipal(),realmName);
        */
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        JdbcRealm jdbcRealm = (JdbcRealm)securityManager.getRealms().iterator().next();
        //删除登陆人
        jdbcRealm.getAuthorizationCache().remove(subject.getPrincipal());
        //删除登陆人对应的缓存
        jdbcRealm.getAuthorizationCache().remove(subject.getPrincipals());
        //重新加载subject
        subject.releaseRunAs();

    }



    /**
     * 权限异常
     */
//    配置权限异常返回json，否则跳转至在shiro.xml配置的路径
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        System.out.println( SecurityUtils.getSubject().getPrincipal());
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","没有权限");
            out.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
