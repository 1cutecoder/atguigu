package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/9/3 15:44
 */
public class BlockingQueueExceptionDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println("blockingQueue add a result "+blockingQueue.add("a"));
        System.out.println("blockingQueue add b result "+blockingQueue.add("b"));
        System.out.println("blockingQueue add c result "+blockingQueue.add("c"));
        blockingQueue.element();
        System.out.println("blockingQueue "+blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
    public void offderAndPoll() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        //下面这个会阻塞2s
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    }
}
