package se;

import java.util.Date;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/22 17:08
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        // Thu May 23 10:05:02 CST 2021
        System.out.println(date);
        Date epoch = new Date(0);
        // Thu Jan 01 08:00:00 CST 1970
        System.out.println(epoch);
        Date date1 = new Date((-24) * 3600 * 1000);
        //Wed Dec 31 08：00：00 CST 1969
        System.out.println(date);
        Date maxDate = new Date(Long.MAX_VALUE);
        //Sun Aug 17 15：12：55 CST 29227899
        System.out.println(maxDate);
    }
}
