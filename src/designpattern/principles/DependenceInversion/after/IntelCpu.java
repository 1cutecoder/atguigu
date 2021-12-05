package designpattern.principles.DependenceInversion.after;

/**
 * @author zcl
 * @date 2021/11/29 16:25
 */
public class IntelCpu implements Cpu{
    @Override
    public void run() {
        System.out.println("使用Intel处理器");
    }
}
