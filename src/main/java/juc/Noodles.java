package juc;

/**
 * @author zcl
 * @date 2021/9/3 14:34
 */
public class Noodles {
    //�������
    private int num = 0;

    public synchronized void makeNoodles() throws InterruptedException {
        if (num != 0) {
            this.wait();
        }
        if (num == 0) {
            num++;
            System.out.println(Thread.currentThread().getName() + "������һ���棬��ǰ��" + num + "����");
            this.notifyAll();
        }

    }

    public synchronized void eatNoodles() throws InterruptedException {
        if (num == 0) {
            this.wait();
        }
        if (num != 0) {
            num--;
            System.out.println(Thread.currentThread().getName() + "����һ���棬��ǰ��" + num + "����");
            this.notifyAll();
        }

    }
}
