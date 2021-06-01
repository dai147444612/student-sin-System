package com.inet.drh.realm;

import com.inet.drh.entity.po.Permission;
import com.inet.drh.entity.po.User;
import com.inet.drh.entity.token.JwtToken;
import com.inet.drh.entity.vo.AllUserInfo;
import com.inet.drh.service.IRoleService;
import com.inet.drh.service.IUserService;
import com.inet.drh.util.JwtUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * INetRealm
 *
 * @author HCY
 * @since 2021/3/5 下午12:56
 */
@Service
public class InetRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(com.inet.drh.realm.InetRealm.class);


    private IUserService userService;
    @Resource
    private IRoleService iRoleService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    public IUserService setUserService(IUserService userService) {
        return this.userService = userService;
    }

    /**
     * 一定需要创建,不然出错
     *
     * @param token token令牌
     * @return 布尔值
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 权限认证
     *
     * @param principalCollection token类
     * @return AuthorizationInfo用户数据
     * @author HCY
     * @since 2020-10-11
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取
        String userId = JwtUtils.getString(principalCollection.toString(), "userId");
        AllUserInfo user = userService.findAllByUsername(userId);
        //创建 simpleAuthorizationInfo 对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加 role 权限
        simpleAuthorizationInfo.addRole(iRoleService.selectRole(userId));
        //数据的转换
        Set<String> permission = new HashSet<>();
        //循环插入
        for (Permission resource : user.getPermissions()) {
            permission.add(resource.getPermissions());
        }
        //添加资源
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 身份验证
     *
     * @param authenticationToken token
     * @return AuthenticationInfo 用户信息
     * @throws AuthenticationException
     * @author HCY
     * @since 2020-10-11
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getCredentials().toString();
        //通过解密获得账号和密码
        String userId = JwtUtils.getString(token, "userId");

        AllUserInfo userToken = (AllUserInfo) redisTemplate.opsForValue().get(token);
        //进行查询
        User user = userService.findAllByUsername1(userId);
        if (userToken == null) {
            throw new AuthenticationException("用户未登陆");
        }
        if (user == null) {
            throw new AuthenticationException("用户不存在");
        }
        if (!JwtUtils.verify(token)) {
            throw new AuthenticationException("token出现错误");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
