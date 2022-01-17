package jvm.t1;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcl
 * @date 2022/1/17 15:20
 */
public class Demo01_19 {
    public static void main(String[] args) throws IOException {
        Dept dept = new Dept();
        dept.setName("Market");
        Emp emp = new Emp();
        emp.setName("zhangsan");
        Emp emp1 = new Emp();
        emp1.setName("lisi");

        dept.setEmps(Arrays.asList(emp,emp1));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(dept));

    }
}

class Emp{
    private String name;
    private Dept dept;

    public String getName() {
        return name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Emp{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dept=").append(dept);
        sb.append('}');
        return sb.toString();
    }
}

class Dept{
    private String name;

    private List<Emp> emps;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public String getName() {
        return name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dept{");
        sb.append("name='").append(name).append('\'');
        sb.append(", emps=").append(emps);
        sb.append('}');
        return sb.toString();
    }
}
