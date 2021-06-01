package com.inet.drh.service.Impl;

import com.inet.drh.entity.po.Role_user;
import com.inet.drh.mapper.Role_userMapper;
import com.inet.drh.service.IRole_userService;
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
public class Role_userServiceImpl extends ServiceImpl<Role_userMapper, Role_user> implements IRole_userService {
    @Resource
    private Role_userMapper role_userMapper;

    //根据学号获取角色序号
    @Override
    public String getRole(String id) {
        return role_userMapper.getRole(id);
    }

    //添加学号和角色序号
    @Override
    public void insertRole(String id, String RoleId) {
        role_userMapper.insertRole(id, RoleId);
    }
}
