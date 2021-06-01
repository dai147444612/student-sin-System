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
public class Permission_user implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String permissionId;

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

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission_user{" +
                "id=" + id +
                ", userId=" + userId +
                ", permissionId=" + permissionId +
                "}";
    }
}
