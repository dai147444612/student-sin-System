package com.inet.drh.service.Impl;

import com.inet.drh.entity.po.Role;
import com.inet.drh.mapper.RoleMapper;
import com.inet.drh.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public void insertRole(String roleId, String roleName) {
        roleMapper.insertRole(roleId, roleName);
    }

    @Override
    public String selectRole(String roleId) {
        return roleMapper.selectRole(roleId);
    }
}
