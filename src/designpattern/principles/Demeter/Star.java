package designpattern.principles.Demeter;

/**
 * @author zcl
 * @date 2021/12/1 14:57
 */
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
