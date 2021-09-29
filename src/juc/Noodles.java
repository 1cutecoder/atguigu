package juc;

/**
 * @author zcl
 * @date 2021/9/3 14:34
 */
public class Noodles {
    //面的数量
    private int num = 0;
    public synchronized void makeNoodles() throws InterruptedException {
        if (num != 0) {
            this.wait();
        }
        if (num == 0) {
            num++;
            System.out.println(Thread.currentThread().getName()+"做好了一份面，当前有"+num+"份面");
            this.notifyAll();
        }

    }
    public synchronized void eatNoodles() throws InterruptedException {
        if (num == 0) {
            this.wait();
        }
        if (num!=0) {
            num--;
            System.out.println(Thread.currentThread().getName()+"吃了一份面，当前有"+num+"份面");
            this.notifyAll();
        }

    }
}
