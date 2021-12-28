package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/28 14:41
 */
public class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("street='").append(street).append('\'');
        sb.append(", roomNo='").append(roomNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
