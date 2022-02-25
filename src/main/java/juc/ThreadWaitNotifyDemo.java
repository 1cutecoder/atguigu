package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcl
 * @date 2021/9/3 9:55
 */
/*
 * ʹ��Lock����Synchronized��ʵ���°�������ߺ�������ģʽ !
 * */
@SuppressWarnings("all")
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) airCondition.decrement();
        }, "�߳�A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) airCondition.increment();
        }, "�߳�B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) airCondition.decrement();
        }, "�߳�C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) airCondition.increment();
        }, "�߳�D").start();
    }
}

class AirCondition {
    private int number = 0;
    //����Lock������
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    //������,���number=0�� number++
    public void increment() {
        lock.lock();
        try {
            //1.�ж�
            while (number != 0) {
                try {
                    condition.await();//this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.�ɻ�
            number++;
            System.out.println(Thread.currentThread().getName() + ":\t" + number);
            //3.����
            condition.signalAll();//this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //������,���number=1,�� number--
    public void decrement() {
        lock.lock();
        try {
            //1.�ж�
            while (number == 0) {
                try {
                    condition.await();//this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.�ɻ�
            number--;
            System.out.println(Thread.currentThread().getName() + ":\t" + number);
            //3.����
            condition.signalAll();//this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
