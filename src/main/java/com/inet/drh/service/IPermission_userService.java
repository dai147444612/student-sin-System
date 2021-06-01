package com.inet.drh.service;

import com.inet.drh.entity.po.Permission_user;
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
public interface IPermission_userService extends IService<Permission_user> {
    //    根据学号查找用户权限
    String findPermission(String number);

    //增加学号和用户权限
    void insertPermissions(String id, String permissionId);
}
