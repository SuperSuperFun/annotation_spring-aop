package com.wangli.target;

import com.wangli.annotation.Description;
import org.springframework.stereotype.Component;

//@Component
public class Operator {

    @Description(value = "调用testAop方法")
    public String testAop() {
        return "SUCCESS";
    }
}
