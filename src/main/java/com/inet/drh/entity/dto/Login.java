package com.inet.drh.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ApiModel("用户登录实体类")
public class Login {
    @ApiModelProperty("账号")
    String username;
    @ApiModelProperty("密码")
    String password;
}
