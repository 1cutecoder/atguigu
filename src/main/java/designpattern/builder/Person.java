package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/28 14:35
 */
public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person() {
    }

    public static class PersonBuilder {
        Person p = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }

        public PersonBuilder weight(double weight) {
            p.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            p.score = score;
            return this;
        }

        public PersonBuilder loc(String street, String roomNo) {
            Location loc = new Location(street, roomNo);
            p.loc = loc;
            return this;
        }
    }
}
