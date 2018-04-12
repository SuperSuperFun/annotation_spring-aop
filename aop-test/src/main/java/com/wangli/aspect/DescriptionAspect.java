package com.wangli.aspect;

import com.wangli.annotation.Description;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DescriptionAspect {

    @Pointcut("execution(* com.wangli.target.Operator.*(..))")
    public void point(){

    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod();
            Description description = method.getAnnotation(Description.class);
            String value = description.value();
            System.out.println("通过AOP获取方法上自定义注解的值value=" + value);
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
