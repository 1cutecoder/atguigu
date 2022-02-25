package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t �������" + data + "�ɹ�");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t �������" + data + "ʧ��");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t���ϰ��ͣ�ˣ���ʾFLAG=false,������������");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t ����2����û��ȡ�����⣬�����˳�");
            }
            System.out.println(Thread.currentThread().getName() + "\t ���Ѷ���" + result + "�ɹ�");
        }
        System.out.println(Thread.currentThread().getName() + "\t���ϰ��ͣ�ˣ���ʾFLAG=false,���Ѷ�������");
    }

    public void stop() {
        this.FLAG = false;
    }
}

/**
 * @author zcl
 * @date 2021/9/6 16:22
 * <p>
 * volatile/CAS/atomicreference/BlockQueue
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t �����߳�����");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t �����߳�����");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5����ʱ�䵽�����ϰ�main�߳̽�ͣ�������");
        myResource.stop();
    }
}
