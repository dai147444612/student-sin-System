package com.inet.drh.service;

import com.inet.drh.entity.po.Role;
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
public interface IRoleService extends IService<Role> {
    void insertRole(String roleId, String roleName);

    //根据角色序号查询角色
    String selectRole(String roleId);
}
