package se.annotation;

/**
 * @author zcl
 * @date 2021/10/8 10:57
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student("CuteCoder", 18);
        System.out.println("student = " + student);
        Student student1 = new Student("����ǧ��������",1000);
        System.out.println("student1 = " + student1);
        Student student2 = StudentFactory.getStudent("����ǧ��������121", 100);
        System.out.println("student2 = " + student2);
    }
}
