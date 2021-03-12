package com.first.loan.request;

import lombok.Data;

@Data
public class RoleCreateRequest {

    private Long roleId;

    private String roleName;

    private String comment;

}
