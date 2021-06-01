package com.inet.drh.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ApiModel("用户分页")
public class UserPage {
    String number;
    String CheckState;
    String name;
}
