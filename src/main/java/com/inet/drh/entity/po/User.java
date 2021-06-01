package com.inet.drh.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String number;

    private String name;

    private String phone;

    private String classes;

    private Date creattime;

    private Date Modified;

    private String username;

    private String password;


}
