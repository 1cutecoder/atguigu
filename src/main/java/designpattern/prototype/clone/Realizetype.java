package designpattern.prototype.clone;

/**
 * @author zcl
 * @date 2021/12/8 15:26
 */
public class Realizetype implements Cloneable{
    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体的原型对象复制成功！");
        return (Realizetype) super.clone();
    }
}
