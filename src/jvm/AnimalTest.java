package jvm;


class Animal {
    public void eat() {
        System.out.println("�����ʳ");
    }
}

interface Huntable {
    /**
     * ��ʳ
     */
    void hunt();
}

class Dog extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("���Թ�ͷ");
    }

    @Override
    public void hunt() {
        System.out.println("��ʳ���ӣ��������");
    }
}

class Cat extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("è����");
    }

    @Override
    public void hunt() {
        System.out.println("è׽�����쾭����");
    }
}

/**
 * @author zcl
 * @date 2021/10/15 15:14
 */
public class AnimalTest {
    public void showAnimal(Animal animal) {
        //����Ϊ�������ڰ�
        animal.eat();
    }

    public void showHunt(Huntable h) {
        //����Ϊ�����ڰ�
        h.hunt();
    }
}
