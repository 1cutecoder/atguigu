package juc;

import java.util.concurrent.TimeUnit;


/**
 * ��֤volatile�Ŀɼ���:
 * 1.����int number=0; number����֮ǰû�����volatile�ؼ�������,û�пɼ���
 * 2.�����volatile,���Խ���ɼ�������
 */
class Resource {
    //volatile int number=0;
    volatile int number = 0;

    public void addNumber() {
        this.number = 60;
    }
}

/**
 * @author zcl
 * @date 2021/9/3 9:24
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t coming ");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.addNumber();
            System.out.println(Thread.currentThread().getName() + "\t update " + resource.number);
        }, "�߳�A").start();

        //������̷߳���resource.number==0,��ô��һֱ����ѭ��
        while (resource.number == 0) {

        }
        //���ִ�е�������,֤��main����ͨ��resource.number��ֵΪ60
        System.out.println(Thread.currentThread().getName() + "\t" + resource.number);

    }
}
