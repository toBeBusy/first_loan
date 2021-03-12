package com.first.loan.service.impl;

import com.first.loan.entity.PrivilegeEntity;
import com.first.loan.entity.RolePrivilegeEntity;
import com.first.loan.entity.UserRoleEntity;
import com.first.loan.form.PermissionQueryForm;
import com.first.loan.repository.PrivilegeRepository;
import com.first.loan.repository.RolePrivilegeRepository;
import com.first.loan.repository.UserRoleRepository;
import com.first.loan.request.PrivilegeCreateRequest;
import com.first.loan.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Resource
    private PrivilegeRepository privilegeRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Override
    public void create(PrivilegeCreateRequest request) {
        privilegeRepository.save(convertToEntity(request));
    }

    private PrivilegeEntity convertToEntity(PrivilegeCreateRequest request) {
        PrivilegeEntity entity = new PrivilegeEntity();
        entity.setPrivilegeId(request.getPrivilegeId());
        entity.setPrivilegeName(request.getPrivilegeName());
        entity.setComment(request.getComment());
        return entity;
    }

    @Override
    public boolean hasPrivilege(PermissionQueryForm form) {
        List<UserRoleEntity> userRoleEntities = userRoleRepository.findByUserId(form.getUserId());
        List<RolePrivilegeEntity> rolePrivilegeEntities =
                rolePrivilegeRepository.findByRoleIds(userRoleEntities.stream().map(x -> x.getRoleId()).collect(Collectors.toList()));

        return rolePrivilegeEntities.stream()
                .map(x -> x.getPrivilegeId()).collect(Collectors.toList()).contains(form.getPrivilegeId());
    }

}