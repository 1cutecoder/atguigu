package designpattern.strategy;

/**
 * Created by cute coder
 * 2021/12/11 15:58
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog t1, Dog t2) {
        if (t1.age < t2.age) return -1;
        else if (t1.age > t2.age) return 1;
        else return 0;
    }
}
