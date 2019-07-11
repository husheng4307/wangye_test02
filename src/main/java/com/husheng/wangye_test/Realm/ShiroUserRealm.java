package com.husheng.wangye_test.Realm;

import com.husheng.wangye_test.model.ShiroUserDomain;
import com.husheng.wangye_test.service.ShiroUser.ShiroUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private ShiroUserService shiroUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        ShiroUserDomain user = (ShiroUserDomain) subject.getPrincipal();
        ShiroUserDomain dbUser = shiroUserService.findById(user.getId());
        info.addStringPermission(dbUser.getPerms());
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken token  =  (UsernamePasswordToken)authenticationToken;

        ShiroUserDomain user = shiroUserService.findByName(token.getUsername());

        //1、判断用户名
        if(user == null){
            //用户名不存在
            return null;
            //shiro底层会抛出UnKnowAccountException
        }

        //2、判断密码, 这里的user是principal
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
