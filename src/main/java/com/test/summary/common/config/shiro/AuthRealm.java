//package com.test.summary.common.config.shiro;
//
//import com.test.summary.common.component.RedisClient;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author Administrator
// * @date 2018/8/24.
// */
//public class AuthRealm extends AuthorizingRealm {
//
//    @Autowired
//    private LoginInfoService loginInfoService;
//    @Autowired
//    private RedisSessionDAO redisSessionDAO;
//    @Autowired
//    private RedisClient redisClient;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("AuthRealm权限验证");
//        LoginInfo loginInfo = (LoginInfo) principalCollection.getPrimaryPrincipal();
////        Integer userId = user.getUid();
////        Set<String> setList = userService.findPower(userId.toString());
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
////        Set<String> rolesSet = new HashSet<>();
////        rolesSet.add("customer");
////        rolesSet.add("admin");
////        info.setRoles(rolesSet);
////        info.setStringPermissions(setList);
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        LoginInfo loginInfo = loginInfoService.findUser(username);
//        if (loginInfo == null) {
//            throw new IncorrectCredentialsException("该账号未注册哦！");
//        }
////        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
////        for (Session session : sessions) {
////            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null && (loginInfo.toString()).equals(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY).toString())) {
////                throw new ConcurrentAccessException("早已登陆！或在别处登录！");
////            }
////        }
//        //return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
//        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                loginInfo, //用户名
//                loginInfo.getPassword(), //密码
//                ByteSource.Util.bytes(ApiConstant.NAME + loginInfo.getSalt()),//salt=username+salt,采用明文访问时，不需要此句
//                getName()  //realm name
//        );
//        return authenticationInfo;
//    }
//}
