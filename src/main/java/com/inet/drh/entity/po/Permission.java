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
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String permissions;

    public Permission(String number, String permission) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissions=" + permissions +
                "}";
    }
}
