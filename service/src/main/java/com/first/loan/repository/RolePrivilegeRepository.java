package com.first.loan.repository;

import com.first.loan.entity.RolePrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolePrivilegeRepository  extends JpaRepository<RolePrivilegeEntity, Long> {

    List<RolePrivilegeEntity> findByRoleId(Long roleId);

    @Query(value = "select * from role_privilege where role_id in (:roleIds)", nativeQuery = true)
    List<RolePrivilegeEntity> findByRoleIds(@Param("roleIds") List<Long> roleIds);

}
