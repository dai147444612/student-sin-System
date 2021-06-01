package com.inet.drh.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ApiModel("用户注册实体类")
public class Register {
    @ApiModelProperty("注册账号")
    String username;
    @ApiModelProperty("注册密码")
    String password;
    @ApiModelProperty("用户姓名")
    String name;
    @ApiModelProperty("用户电话")
    String phone;
    @ApiModelProperty("用户学号")
    String number;
    @ApiModelProperty("用户班级")
    String classes;
}
