package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/9/22 10:06
 */
public class eightlockdemo {
    /**
     * ①一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，
     * 其他的线程都只能等待，换句话说，某一时刻内，只能有唯一一个线程去访问这些synchronized方法。
     * <p>
     * ②锁的是当前对象this，被锁定后，其他线程都不能进入到当前对象的其他的synchronized方法。
     * <p>
     * ③加个普通方法后发现和同步锁无关。
     * <p>
     * ④换成静态同步方法后，情况又变化
     * <p>
     * ⑤所有的非静态同步方法用的都是同一把锁 -- 实例对象本身，也就是说如果一个实例对象的非静态同步方法获取锁后，
     * 该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为
     * 跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已经取锁的非静态同步方法释放锁就可以获取
     * 他们自己的锁。
     * <p>
     * ⑥所有的静态同步方法用的也是同一把锁 -- 类对象本身，这两把锁是两个不同的对象，所以静态同步方法与非静态同步
     * 方法之间不会有竞争条件。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获
     * 取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们是同一个lei
     * 对象
     */
    public static void main(String[] args) {
            Animal4 animal1=new Animal4();
            Animal4 animal2=new Animal4();

            new Thread(()->{
                animal2.wuGui();
            }).start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(()->{
                animal2.tuZi();
            }).start();
        }
    }

    class Animal4{

        public static synchronized void wuGui(){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("乌龟先跑");
        }
        public synchronized void tuZi(){
            System.out.println("兔子先跑");
        }
    }

