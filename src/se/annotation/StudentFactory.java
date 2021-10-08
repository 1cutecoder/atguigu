package se.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zcl
 * @date 2021/10/8 11:00
 */
public class StudentFactory {
    public static Student getStudent(String name, int age) {
        Student student = null;
        try {
            Class<Student> studentClass = Student.class;
            Field nameField = studentClass.getDeclaredField("name");
            int minLength = 0;
            int maxLength = 0;
            int minaAge = 0;
            int maxaAge = 0;
            if (nameField.isAnnotationPresent(NameConstraint.class)) {
                NameConstraint nameConstraint = nameField.getAnnotation(NameConstraint.class);
                minLength = nameConstraint.minLength();
                maxLength = nameConstraint.maxength();
            }
            //判断名字长度是否合法
            int length = name.trim().length();
            if (length < minLength || length > maxLength) {
                throw new IllegalArgumentException("name:" + name);
            }
            //判断年龄是否合法
            Field ageField = studentClass.getDeclaredField("age");
            if (ageField.isAnnotationPresent(AgeConstraint.class)) {
                AgeConstraint ageConstraint = ageField.getAnnotation(AgeConstraint.class);
                minaAge = ageConstraint.minAge();
                maxaAge = ageConstraint.maxAge();
            }
            if (age < minaAge || age > maxaAge) {
                throw new IllegalArgumentException("age:" + age);
            }
            Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            student = constructor.newInstance(name, age);
        } catch (NoSuchFieldException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return student;
    }
}
