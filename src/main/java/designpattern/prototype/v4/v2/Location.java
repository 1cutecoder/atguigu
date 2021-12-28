package designpattern.prototype.v4.v2;

/**
 * @author zcl
 * @date 2021/12/28 14:41
 */
public class Location implements Cloneable{
    public StringBuilder street;
    public int roomNo;

    public Location(StringBuilder street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street=" + street +
                ", roomNo=" + roomNo +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
