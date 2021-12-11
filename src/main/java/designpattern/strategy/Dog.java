package designpattern.strategy;

/**
 * Created by cute coder
 * 2021/12/11 15:31
 */
public class Dog implements Comparable<Dog> {
    int age;

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Dog dog) {
        if (this.age < dog.age) return -1;
        else if (this.age > dog.age) return 1;
        else return 0;
    }
}
