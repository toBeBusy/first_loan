package com.first.loan.aop;

import com.first.loan.annotations.Permission;
import com.first.loan.controller.ControllerContext;
import com.first.loan.dto.LoginUser;
import com.first.loan.form.PermissionQueryForm;
import com.first.loan.service.PrivilegeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Aspect
public class ApiBusinessAspect {

    @Resource
    private PrivilegeService privilegeService;

    @Pointcut("execution(* com.first.loan.controller.*(..))")
    public void controllerAspect(ProceedingJoinPoint point) {
        LoginUser loginUser = ControllerContext.getContext().getLoginUser();

        //权限校验
        Boolean validResult = validPermission(point, loginUser);
        if(!validResult){
            // todo
//            throw new BusinessException(ErrorCodeEnum.USER_HAS_NO_PRIVILEGE);
        }
    }

    /**
     * 接口访问权限校验
     * @param point
     * @param loginUser
     * @return
     */
    private boolean validPermission(ProceedingJoinPoint point,LoginUser loginUser) {
        Long privilegeId = getAnnotationPermissionId(point);
        if(null == privilegeId){
            return false;
        }

        PermissionQueryForm permissionQueryForm = new PermissionQueryForm();
        permissionQueryForm.setUserId(loginUser.getUserId());
        permissionQueryForm.setPrivilegeId(privilegeId);
        if(privilegeService.hasPrivilege(permissionQueryForm)) {
            return true;
        }
        return false;
    }

    private Long getAnnotationPermissionId(ProceedingJoinPoint point) {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        Permission permission = targetMethod.getAnnotation(Permission.class);
        //如果没有配置权限注解,不让访问
        if(null == permission) {
            return null;
        }
        //权限校验
        long privilegeId = permission.id();
        return privilegeId;
    }

}