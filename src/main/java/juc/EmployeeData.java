package juc;

import java.util.ArrayList;
import java.util.List;

/**
 * [excel2pdf!] (C)2003-2021 上马(福建)集团有限责任公司. All rights reserved.
 *
 * @version V1.0
 * @Title: juc.EmployeeData
 * @Package demo.java8
 * @Description:
 * @author: Feng.He
 * @create: 2021-09-10 16:48
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 9876.12));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1004, "雷军", 26, 7657.37));
        list.add(new Employee(1005, "李彦宏", 65, 5555.32));
        list.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        list.add(new Employee(1007, "任正非", 26, 4333.32));
        list.add(new Employee(1008, "扎克伯格", 35, 2500.32));
        return list;
    }
}
