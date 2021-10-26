package juc;

import java.lang.ref.WeakReference;

/**
 * @author zcl
 * @date 2021/10/25 16:48
 */
public class T03_WeakReference {
    static class M {
        private int age;
    }

    public static void main(String[] args) {
        /**
         * ������ָ��Ķ�������������һ�����Ϳ��Ի���
         * ��ʹ��ThreadLocalʱ���Ὣtl��Ϊkey value��Ϊֵ���浽��ǰ�߳������е�threadlocalmap��ߣ�tl.remove�����ָ��tl��ǿ���ã�
         * ֻʣһ��������ָ��ǰ�̵߳�threadlocalmap��key������������������ʱ����key�����������ڴ�й¶���ڣ���ΪkeyΪnull��ʹ������value�޷������ʵ���
         */

        WeakReference<Object> weakReference = new WeakReference<>(new M());
        System.out.println("weakReference = " + weakReference.get());
        System.gc();
        System.out.println("weakReference = " + weakReference.get());

    }
}
