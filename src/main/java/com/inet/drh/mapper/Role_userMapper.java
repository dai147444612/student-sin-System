package com.inet.drh.mapper;

import com.inet.drh.entity.po.Role_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Mapper
public interface Role_userMapper extends BaseMapper<Role_user> {
    //根据学号获取角色序号
    String getRole(String id);

    //增加角色和角色序号
    void insertRole(String id, String RoleId);
}
