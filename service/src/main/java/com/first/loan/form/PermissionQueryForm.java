package com.first.loan.form;

import lombok.Data;

/**
 * @author QiuPeng
 *
 * @Description
 **/
@Data
public class PermissionQueryForm {

    // todo 可能换成用户名或者别的，具体看征信那边的登录情况。
    private Long userId;

    private Long privilegeId;
}
