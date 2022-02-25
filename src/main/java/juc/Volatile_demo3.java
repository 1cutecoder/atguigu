package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcl
 * @date 2021/9/3 9:28
 */
public class Volatile_demo3 {
    public static void main(String[] args) {
        /* System.out.println(Thread.activeCount());*/
        AutoResource autoResource = new AutoResource();
        //20���߳�ÿ���߳�ѭ��100��
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    autoResource.numberPlusPlus();
                    autoResource.addAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }
        //��Ҫ�ȴ�����20���̶߳�ȫ���������,����main�߳�ȡ�õ����յĽ��ֵ�Ƕ���
        //Ĭ���������߳�,һ��main�߳�,���Ǻ�̨gc�߳�
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int type " + autoResource.number);
        System.out.println(Thread.currentThread().getName() + "\t AutoInteger type " + autoResource.atomicInteger.get());
    }
}

class AutoResource {
    volatile int number = 0;

    public void numberPlusPlus() {
        number++;

    }

    //ʹ��AutoInteger��֤ԭ����
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomicInteger() {
        atomicInteger.getAndIncrement();
    }
}
