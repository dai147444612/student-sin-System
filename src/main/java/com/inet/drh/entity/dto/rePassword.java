package com.inet.drh.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ApiModel("用户修改密码")
public class rePassword {
    @ApiModelProperty("旧密码")
    String oldPassword;
    @ApiModelProperty("账号")
    String username;
    @ApiModelProperty("学号")
    String number;
    @ApiModelProperty("新密码")
    String newPassword;
}
