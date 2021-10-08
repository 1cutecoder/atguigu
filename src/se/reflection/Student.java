package se.reflection;

/**
 * @author zcl
 * @date 2021/10/8 15:15
 */
public class Student extends Person{

    /**
     * ²âÊÔ·´Éä
     */
    @Override
    public void show() {
        System.out.println("°®Éú»î£¬°®java");
    }
    public void eat(){
        System.out.println("eat");
    }
}
