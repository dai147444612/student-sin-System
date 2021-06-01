package com.inet.drh.entity.vo;

import com.inet.drh.entity.po.Permission;
import com.inet.drh.entity.po.Role;
import com.inet.drh.service.IPermission_userService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel("用户全部信息")
public class AllUserInfo implements Serializable {
    @ApiModelProperty("用户主键")
    String id;
    @ApiModelProperty("用户姓名")
    String name;
    @ApiModelProperty("用户学号")
    String number;
    @ApiModelProperty("用户班级")
    String classes;
    @ApiModelProperty("用户签到总时长")
    String account;
    @ApiModelProperty("用户账号")
    String username;
    @ApiModelProperty("用户电话")
    String phone;
    @ApiModelProperty("权限集合")
    List<Permission> permissions;
}
