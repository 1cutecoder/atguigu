package asm;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/25 13:03
 */
class MyClassLoader extends ClassLoader {
    public Class defineClass(String name,byte[] b) {
        return defineClass(name,b,0,b.length);
    }
}
