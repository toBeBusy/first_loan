package com.first.loan.request;

import lombok.Data;

@Data
public class PrivilegeCreateRequest {

    private Long privilegeId;

    private String privilegeName;

    private String comment;

}
