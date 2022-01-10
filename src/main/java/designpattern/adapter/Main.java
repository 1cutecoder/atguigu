package designpattern.adapter;

import java.io.*;

/**
 * @author zcl
 * @date 2021/12/28 14:58
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:/test.properties");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while (s != null && !"".equals(s)) {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();
    }
}
