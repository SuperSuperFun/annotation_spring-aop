package com.wangli.target;

import com.wangli.annotation.Description;
import org.springframework.stereotype.Component;

//@Component
public class Operator {

    @Description(value = "nice!")
    public String testAop() {
        return "SUCCESS";
    }
}
