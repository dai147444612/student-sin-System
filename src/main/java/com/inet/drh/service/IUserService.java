package com.inet.drh.service;

import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.rePassword;
import com.inet.drh.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.drh.entity.vo.AllUserInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
public interface IUserService extends IService<User> {
    //    注册用户
    void registerUser(User user);

    //    修改密码
    void updatePassword(rePassword rePassword);

    AllUserInfo findAll(Login login, String username);

    //    登录
    String login(String username, String password);

    AllUserInfo findAllByUsername(String username);

    User findAllByUsername1(String username);
}

