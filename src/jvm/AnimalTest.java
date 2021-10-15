package jvm;


class Animal {
    public void eat() {
        System.out.println("动物进食");
    }
}

interface Huntable {
    /**
     * 捕食
     */
    void hunt();
}

class Dog extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }
}

class Cat extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("猫捉老鼠，天经地义");
    }
}

/**
 * @author zcl
 * @date 2021/10/15 15:14
 */
public class AnimalTest {
    public void showAnimal(Animal animal) {
        //表现为：、晚期绑定
        animal.eat();
    }

    public void showHunt(Huntable h) {
        //表现为：晚期绑定
        h.hunt();
    }
}
