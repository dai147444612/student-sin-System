package com.inet.drh.mapper;

import com.inet.drh.entity.po.Permission;
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
public interface PermissionMapper extends BaseMapper<Permission> {
    //    添加学号和权限序号
    void insertPermissionId(String permissionId, String permissions);

    //    根据权限序号查询权限
    List<Permission> selectPermissions(String permissionId);
}
