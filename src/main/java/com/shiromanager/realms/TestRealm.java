package com.shiromanager.realms;

import com.shiromanager.Utils.EncryptUtils;
import com.shiromanager.account.bean.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/11/14
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
		/* 这里编写授权代码 */
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("admin");
        permissions.add("user.do?myjsp");
        permissions.add("login.do?main");
        permissions.add("login.do?logout");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
		/* 这里编写认证代码 */
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		User user = securityApplication.findby(upToken.getUsername());
        User user = new User();
        user.setUsercode(token.getUsername());
        user.setUserName("admin");
        user.setPassword(EncryptUtils.encryptMD5("admin"));
//		if (user != null) {
        return new SimpleAuthenticationInfo(user.getUserName(),
                user.getPassword(), getName());


    }

    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principal, getName());
        clearCachedAuthorizationInfo(principals);
    }
}
