package com.inet.drh.service.Impl;

import com.inet.drh.entity.po.Permission;
import com.inet.drh.mapper.PermissionMapper;
import com.inet.drh.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public void insertPermissionId(String permissionId, String permissions) {
        permissionMapper.insertPermissionId(permissionId, permissions);
    }

    @Override
    public List<Permission> selectPermissions(String permissionId) {
        return permissionMapper.selectPermissions(permissionId);
    }
}
