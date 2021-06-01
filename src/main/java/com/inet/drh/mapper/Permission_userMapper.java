package com.inet.drh.mapper;

import com.inet.drh.entity.po.Permission_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.drh.entity.vo.AllUserInfo;
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
public interface Permission_userMapper extends BaseMapper<Permission_user> {
    //    根据学号查找用户权限
    String findPermission(String number);

    //增加学号和用户权限
    void insertPermissions(String id, String permissionId);
}
