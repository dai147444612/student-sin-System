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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName=" + roleName +
                "}";
    }
}
