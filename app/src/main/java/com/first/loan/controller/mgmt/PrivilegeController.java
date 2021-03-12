package com.first.loan.controller.mgmt;

import com.first.loan.request.PrivilegeCreateRequest;
import com.first.loan.service.PrivilegeService;
import com.first.loan.service.RolePrivilegeService;
import com.first.loan.service.UserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mgmt")
public class PrivilegeController {

    @Resource
    private PrivilegeService privilegeService;

    @Resource
    private RolePrivilegeService rolePrivilegeService;

    @Resource
    private UserRoleService userRoleService;

    /**
     * 新增权限
     */
    @PostMapping("/privilege/create")
    public void create(@RequestBody PrivilegeCreateRequest request) {
        privilegeService.create(request);
    }

}