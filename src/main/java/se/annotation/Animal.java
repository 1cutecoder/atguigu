package se.annotation;

import java.util.Date;

/**
 * @author zcl
 * @date 2021/10/8 10:21
 */
public class Animal {
    @MyAnnotation(value = Date.class)
    public void show(){

    }
}
