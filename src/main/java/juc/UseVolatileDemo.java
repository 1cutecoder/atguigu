package juc;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/9/3 9:33
 */

public class UseVolatileDemo {
    /**
     * ʹ��:����Զ����д�����ʹ���ڲ����� volatile ����������ͬ���Ŀ���
     * ����:����volatile��֤��ȡ�����Ŀɼ���;����synchronized��֤���ϲ�����ԭ����
     */
    public class Counter {
        private volatile int value;

        public int getValue() {
            return value;   //����volatile��֤��ȡ�����Ŀɼ���
        }

        public synchronized int increment() {
            return value++; //����synchronized��֤���ϲ�����ԭ����
        }
    }
}
