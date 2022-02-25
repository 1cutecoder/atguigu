package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:43
 */
public class HonDaWindows extends Windows {
    private String color;
    private String material;

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HonDaWindows{");
        sb.append("color='").append(color).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
