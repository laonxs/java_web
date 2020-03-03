package cn.ade.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author ade
 * @version 1.0，2020-02-25 21:34:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {

    /**
     * 自定义注解中的属性定义
     * 属性格式：修饰符(public abstract) 返回值类型 属性名() [default 默认值]
     * 修饰符：默认public abstract
     * 返回值类型：基本类型 Class 注解 枚举 及以上类型的一维数组
     * 属性名：自定义
     * default 默认值：可以省略
     *
     * @return
     */
    public abstract String username() default "ade";

}
