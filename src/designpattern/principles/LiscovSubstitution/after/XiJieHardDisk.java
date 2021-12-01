package designpattern.principles.LiscovSubstitution.after;

/**
 * @author zcl
 * @date 2021/11/29 16:21
 */
public class XiJieHardDisk implements HardDisk{
    @Override
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据" + data);
    }

    @Override
    public String get() {
        System.out.println("使用希捷希捷硬盘取数据");
        return "数据";
    }
}
