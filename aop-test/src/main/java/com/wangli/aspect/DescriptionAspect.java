package com.wangli.aspect;

import com.wangli.annotation.Description;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class DescriptionAspect {

    @Pointcut("execution(* com.wangli.target.Operator.*(..))")
    public void point(){

    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            long startTime = new Date().getTime();
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod();
            Description description = method.getAnnotation(Description.class);
            String value = description.value();
            System.out.println("通过AOP获取方法上自定义注解的值value=" + value);
            String result = (String) pjp.proceed();
            long endTime = new Date().getTime();
            System.out.println("方法执行的时间是：" + (endTime - startTime));
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
