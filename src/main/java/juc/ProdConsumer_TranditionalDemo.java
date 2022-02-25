package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {//��Դ��
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1 �ж�
            while (number != 0) {
                //�ȴ�����������
                condition.await();
            }
            //�ɻ�
            number++;
            System.out.println(Thread.currentThread().getName() + "\t increment number=" + number);
            //֪ͨ����
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1 �ж�
            while (number == 0) {
                //�ȴ�����������
                condition.await();
            }
            //�ɻ�
            number--;
            System.out.println(Thread.currentThread().getName() + "\t decrement number= " + number);
            //֪ͨ����
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @author zcl
 * @date 2021/9/6 11:19
 * һ����ʼֵΪ��ı����������̶߳��佻�������һ����1һ����1����5��
 * 1 �߳�    ����(����)      ��Դ��
 * 2 �ж�    �ɻ�      ֪ͨ
 * 3 ��ֹ��ٻ��ѻ���
 */
public class ProdConsumer_TranditionalDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
