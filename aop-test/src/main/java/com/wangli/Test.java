package com.wangli;

import com.wangli.target.Operator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
        Operator operator = (Operator)ac.getBean("operator");
        String retVal = operator.testAop();
        System.out.println("测试方法的返回值是：" + retVal);
    }
}
