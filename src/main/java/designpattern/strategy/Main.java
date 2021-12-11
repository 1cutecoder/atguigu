package designpattern.strategy;

import java.util.Arrays;

/**
 * Created by cute coder
 * 2021/12/11 15:08
 */
public class Main {
    public static void main(String[] args) {
        //简单实现策略
        /* Cat[] a = {new Cat(1,1),new Cat(5,5),new Cat(3,3)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));*/
        //泛型
       Dog[] a = {new Dog(1),new Dog(5),new Dog(3)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
