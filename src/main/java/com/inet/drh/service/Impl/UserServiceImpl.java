package com.inet.drh.service.Impl;

import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.rePassword;
import com.inet.drh.entity.po.User;
import com.inet.drh.entity.vo.AllUserInfo;
import com.inet.drh.mapper.PermissionMapper;
import com.inet.drh.mapper.UserMapper;
import com.inet.drh.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;

    //注册用户
    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

    //修改密码
    @Override
    public void updatePassword(rePassword rePassword) {
        userMapper.updatePassword(rePassword);
    }

    //查询用户所有信息
    @Override
    public AllUserInfo findAll(Login login, String username) {
        return userMapper.findAll(login).setPermissions(userMapper.getPermissions(username));
    }

    //登录
    @Override
    public String login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public AllUserInfo findAllByUsername(String username) {
        return userMapper.findAllByUsername(username).setPermissions(userMapper.getPermissions(username));
    }

    @Override
    public User findAllByUsername1(String username) {
        return userMapper.findAllByUsername1(username);
    }
}
