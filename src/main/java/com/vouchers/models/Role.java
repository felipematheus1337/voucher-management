package com.vouchers.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {

    @Id
    private String roleId;

    private String name;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        BASIC("BASIC"),
        ADMIN("ADMIN");

        String roleId;

        Values(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleId() {
            return roleId;
        }
    }
}
