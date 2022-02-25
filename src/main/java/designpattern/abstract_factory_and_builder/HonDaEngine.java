package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:43
 */
public class HonDaEngine extends Engine {
    private double oilConsume;

    public void setOilConsume(double oilConsume) {
        this.oilConsume = oilConsume;
    }

    public double getOilConsume() {
        return oilConsume;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HonDaEngine{");
        sb.append("oilConsume=").append(oilConsume);
        sb.append('}');
        return sb.toString();
    }
}
