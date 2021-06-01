package com.inet.drh.service;

import com.inet.drh.entity.po.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
public interface IPermissionService extends IService<Permission> {
    //    添加学号和权限序号
    void insertPermissionId(String permissionId, String permissions);

    //    根据权限序号查询权限
    List<Permission> selectPermissions(String permissionId);
}
