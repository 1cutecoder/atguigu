package designpattern.principles.LiscovSubstitution.after;

/**
 * @author zcl
 * @date 2021/11/29 16:26
 */
public class KingstonMemory implements Memory {
    @Override
    public void save() {
        System.out.println("使用金士顿作为内存条");
    }
}
