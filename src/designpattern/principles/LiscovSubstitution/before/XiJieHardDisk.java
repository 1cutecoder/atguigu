package designpattern.principles.LiscovSubstitution.before;

/**
 * @author zcl
 * @date 2021/11/29 16:21
 */
public class XiJieHardDisk {
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据" + data);
    }

    public String get() {
        System.out.println("使用希捷希捷硬盘取数据");
        return "数据";
    }
}
