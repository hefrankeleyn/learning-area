package com.hef.aop.aspect05;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    /**
     * value 属性指定了哪种类型的bean要引入该接口；
     * defaultImple 属性指定了为引入功能提供实现的类
     * 注解标注的静态属性指明了要引入的接口
     */
    @DeclareParents(value = "com.hef.aop.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
