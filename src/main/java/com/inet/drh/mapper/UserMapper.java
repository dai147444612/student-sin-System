package com.inet.drh.mapper;

import com.inet.drh.entity.dto.Login;
import com.inet.drh.entity.dto.rePassword;
import com.inet.drh.entity.po.Permission;
import com.inet.drh.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.drh.entity.vo.AllUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //    注册用户
    void registerUser(User user);

    //    修改密码
    void updatePassword(rePassword rePassword);

    //获取信息
    AllUserInfo findAll(Login login);

    //    登录
    String login(String username, String password);

    //获取权限
    List<Permission> getPermissions(String username);

    AllUserInfo findAllByUsername(String username);

    User findAllByUsername1(String username);
}
