package se.annotation;

/**
 * @author zcl
 * @date 2021/10/8 10:51
 */
public class Student {

    /**
     * 名字的长度不能低于两个字符，不能大于10个字符
     */
    @NameConstraint(minLength = 2, maxength = 10)
    private String name;
    /**
     * age不能小于3岁，不能大于120
     */
    @AgeConstraint(minAge = 3, maxAge = 120)
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
