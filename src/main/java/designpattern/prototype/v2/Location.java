package designpattern.prototype.v2;

/**
 * @author zcl
 * @date 2021/12/28 14:41
 */
public class Location implements Cloneable {
    public String street;
    public int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("street='").append(street).append('\'');
        sb.append(", roomNo='").append(roomNo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
