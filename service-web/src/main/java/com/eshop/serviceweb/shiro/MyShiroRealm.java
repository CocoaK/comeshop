package com.eshop.serviceweb.shiro;

import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.impl.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
//    @Autowired
//    private SysRoleService roleService;
    @Autowired
    private UserService userService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
//        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//        String name = token.getUsername();
//        String password = String.valueOf(token.getPassword());
//       User u = new User();
//        u.setUserName(name);
//        u.setUserPwd(password);
//        // 从数据库获取对应用户名密码的用户
//        User user = userService.getByUser(u);
//        if (user != null) {
//            // 用户为禁用状态
//            if (user.getStatus() != 1) {
//                throw new DisabledAccountException();
//            }
//            logger.info("---------------- Shiro 凭证认证成功 ----------------------");
//            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                    user, //用户
//                    user.getPassword(), //密码
//                    getName()  //realm name
//            );
//            return authenticationInfo;
//        }
//        throw new UnknownAccountException();
        return null;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof User) {
            User userLogin = (User) principal;
//            Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId());
//            authorizationInfo.addRoles(roles);

//            Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());
//            authorizationInfo.addStringPermissions(permissions);
        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }

}
