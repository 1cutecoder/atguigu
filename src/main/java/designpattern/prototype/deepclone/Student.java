package designpattern.prototype.deepclone;

import java.io.Serializable;

/**
 * @author zcl
 * @date 2021/12/8 17:36
 */
public class Student implements Serializable {
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
