package com.first.loan.service;

import com.first.loan.form.PermissionQueryForm;
import com.first.loan.request.PrivilegeCreateRequest;

public interface PrivilegeService {

    void create(PrivilegeCreateRequest request);

    boolean hasPrivilege(PermissionQueryForm form);
}
