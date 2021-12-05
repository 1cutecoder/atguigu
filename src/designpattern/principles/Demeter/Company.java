package designpattern.principles.Demeter;

/**
 * @author zcl
 * @date 2021/12/1 14:58
 */
public class Company {
    String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
