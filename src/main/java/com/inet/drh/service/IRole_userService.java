package com.inet.drh.service;

import com.inet.drh.entity.po.Role_user;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
public interface IRole_userService extends IService<Role_user> {
    //根据学号获取角色序号
    String getRole(String id);

    //增加角色和角色序号
    void insertRole(String id, String RoleId);
}
