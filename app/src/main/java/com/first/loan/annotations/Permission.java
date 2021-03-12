package com.first.loan.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    /**
     * 权限许可码
     * @return
     */
    public long id() default -1;

    /**
     * 权限许可描述
     * @return
     */
    public String desc() default "";

}