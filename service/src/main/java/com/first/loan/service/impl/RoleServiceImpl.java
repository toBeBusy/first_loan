package com.first.loan.service.impl;

import com.first.loan.entity.RoleEntity;
import com.first.loan.repository.RoleRepository;
import com.first.loan.request.RoleCreateRequest;
import com.first.loan.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository repository;

    @Override
    public void create(RoleCreateRequest request) {
        repository.save(convertToEntity(request));
    }

    private RoleEntity convertToEntity(RoleCreateRequest request) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(request.getRoleId());
        entity.setRoleName(request.getRoleName());
        entity.setComment(request.getComment());
        return entity;
    }

}