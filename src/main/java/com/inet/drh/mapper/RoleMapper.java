package com.inet.drh.mapper;

import com.inet.drh.entity.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RoleMapper extends BaseMapper<Role> {
    void insertRole(String roleId, String roleName);

    //根据角色序号查询角色
    String selectRole(String roleId);
}
