package designpattern.factory.static_factory;

/**
 * @author zcl
 * @date 2021/12/8 9:37
 */
public enum CoffeeType {
    /**
     * ��������
     */
    LATTE(),
    /**
     * ��������
     */
    AMERICAN();
    /**
     * ����
     */
    private String desc;

    String getCode() {
        return toString();
    }

    String getDesc() {
        return this.name();
    }

    boolean eq(String val) {
        return this.getCode().equalsIgnoreCase(val);
    }

    String getValue() {
        return getCode();
    }
}
