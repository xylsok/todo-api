package com.todo.memo.aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by zhangzf on 2018/5/15.
 */
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Before("execution(public * com.todo.memo.ui.RedisTest.test2(..))")
    public void log(){
        System.out.println("log");
    }
}
