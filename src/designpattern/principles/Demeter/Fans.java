package designpattern.principles.Demeter;

/**
 * @author zcl
 * @date 2021/12/1 14:59
 */
public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
