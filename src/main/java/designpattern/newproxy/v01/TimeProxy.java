package designpattern.newproxy.v01;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDateTime;

/**
 * @author zcl
 * @date 2021/12/21 16:20
 */
@Aspect
public class TimeProxy {
    @Before("execution (void designpattern.newproxy.v01.Tank.move())")
    public void before() {
        System.out.println("method start .." + LocalDateTime.now());
    }

    @After("execution (void designpattern.newproxy.v01.Tank.move())")
    public void after() {
        System.out.println("method end .." + LocalDateTime.now());
    }
}
