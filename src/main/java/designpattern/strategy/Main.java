package designpattern.strategy;

import java.util.Arrays;

/**
 * Created by cute coder
 * 2021/12/11 15:08
 */
public class Main {
    public static void main(String[] args) {
        //��ʵ�ֲ���
        /* Cat[] a = {new Cat(1,1),new Cat(5,5),new Cat(3,3)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));*/
        //����
       /*Dog[] a = {new Dog(1),new Dog(5),new Dog(3)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));*/
        Dog[] a = {new Dog(1),new Dog(5),new Dog(3)};
        Sorter sorter = new Sorter<Dog>();
        sorter.sort(a,new DogComparator());
        System.out.println(Arrays.toString(a));
        //��������è��������
        System.out.println("======================");
        Cat[] cats = {new Cat(7,1),new Cat(5,5),new Cat(3,3)};
        Sorter<Cat> sorter1 = new Sorter();
        sorter.sort(cats,new CatWeightComparator());
        System.out.println(Arrays.toString(cats));
    }
}
