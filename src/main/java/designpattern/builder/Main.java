package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/28 14:29
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().basicInfo(1, "zhangsan", 18).weight(200).build();
        System.out.println(person);
    }
}
