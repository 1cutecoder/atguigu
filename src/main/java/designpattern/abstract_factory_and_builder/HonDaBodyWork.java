package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:28
 */
public class HonDaBodyWork extends BodyWork {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HonDaBodyWork{");
        sb.append("color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void setColor() {

    }

    @Override
    public String show() {
        return this.toString();
    }
}
