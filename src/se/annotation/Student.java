package se.annotation;

/**
 * @author zcl
 * @date 2021/10/8 10:51
 */
public class Student {

    /**
     * ���ֵĳ��Ȳ��ܵ��������ַ������ܴ���10���ַ�
     */
    @NameConstraint(minLength = 2, maxength = 10)
    private String name;
    /**
     * age����С��3�꣬���ܴ���120
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
