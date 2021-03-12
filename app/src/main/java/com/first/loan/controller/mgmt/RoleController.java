package com.first.loan.controller.mgmt;

import com.first.loan.request.RoleCreateRequest;
import com.first.loan.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mgmt")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 新增权限
     */
    @PostMapping("/role/create")
    public void create(@RequestBody RoleCreateRequest request) {
        roleService.create(request);
    }

}