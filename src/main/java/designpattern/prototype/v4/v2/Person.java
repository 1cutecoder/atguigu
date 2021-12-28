package designpattern.prototype.v4.v2;


/**
 * @author zcl
 * @date 2021/12/28 14:35
 */
public class Person implements Cloneable{
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc = new Location(new StringBuilder("bj"),2);

    public Person() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", weight=").append(weight);
        sb.append(", score=").append(score);
        sb.append(", loc=").append(loc);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) p.loc.clone();
        return p;
    }
}
