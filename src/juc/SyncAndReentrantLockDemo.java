package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcl
 * @date 2021/9/6 14:12
 * 1.synchronize�ǹؼ�������JVM����
 * monitorenter �ײ���ͨ��monitor���������
 * monitorexit
 * 2.lock��api�������
 * 3.�ȴ��Ƿ���ж�
 * synchronize �����жϣ������жϻ����׳��쳣
 * ReentrantLock �����ж�
 * 4.�����Ƿ�ƽ
 * 5.���󶨶������condition
 * =================================================================================
 * =================================================================================
 * ����߳�֮�䰴˳�����,ʵ��A->B->C
 * �����߳�����,Ҫ������:
 * AA��ӡ5��,BB��ӡ10��,CC��ӡ15��
 * ����
 * AA��ӡ5��,BB��ӡ10��,CC��ӡ15��
 * ....��10��
 */
class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1.�ж�
            while (number != 1) {
                c1.await();
            }
            //2.�ɻ�
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //3.֪ͨ
            number = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1.�ж�
            while (number != 2) {
                c2.await();
            }
            //2.�ɻ�
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //3.֪ͨ
            number = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1.�ж�
            while (number != 3) {
                c3.await();
            }
            //2.�ɻ�
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //3.֪ͨ
            number = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}
