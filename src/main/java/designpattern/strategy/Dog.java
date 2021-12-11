package designpattern.strategy;

/**
 * Created by cute coder
 * 2021/12/11 15:31
 */
public class Dog implements Comparable {
    int age;

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Dog dog = (Dog) o;
        if (this.age < dog.age) return -1;
        else if (this.age > dog.age) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
