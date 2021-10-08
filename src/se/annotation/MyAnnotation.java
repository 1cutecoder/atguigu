package se.annotation;

/**
 * @author zcl
 * @date 2021/10/8 10:05
 */
public @interface MyAnnotation {
    String name() default "Henson_z";
    int age() default 18;
    Class value();
}
