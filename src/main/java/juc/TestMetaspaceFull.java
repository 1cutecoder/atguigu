package juc;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author zcl
 * @date 2022/5/25 15:39
 * 演示元空间的内存溢出
 * -XX:MaxMetaspaceSize=8m
 */
public class TestMetaspaceFull extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            TestMetaspaceFull test = new TestMetaspaceFull();
            for (int i = 0; i < 1000_000; i++) {
                ClassWriter cw = new ClassWriter(0);
                //版本号 ，public修饰符，类名，包名，父类，
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = cw.toByteArray();
                test.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println(j);
        }
    }
}
