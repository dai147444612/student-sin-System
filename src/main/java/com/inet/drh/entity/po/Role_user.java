package com.inet.drh.entity.po;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
public class Role_user implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private Integer RoleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer RoleId) {
        this.RoleId = RoleId;
    }

    @Override
    public String toString() {
        return "Role_user{" +
                "id=" + id +
                ", userId=" + userId +
                ", RoleId=" + RoleId +
                "}";
    }
}
