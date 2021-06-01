package com.inet.drh.service.Impl;

import com.inet.drh.entity.po.Permission_user;
import com.inet.drh.entity.vo.AllUserInfo;
import com.inet.drh.mapper.Permission_userMapper;
import com.inet.drh.service.IPermission_userService;
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
public class Permission_userServiceImpl extends ServiceImpl<Permission_userMapper, Permission_user> implements IPermission_userService {
    @Resource
    private Permission_userMapper permission_userMapper;

    //查找权限
    @Override
    public String findPermission(String number) {
        return permission_userMapper.findPermission(number);
    }

    @Override
    public void insertPermissions(String id, String permissionId) {
        permission_userMapper.insertPermissions(id, permissionId);
    }
}
