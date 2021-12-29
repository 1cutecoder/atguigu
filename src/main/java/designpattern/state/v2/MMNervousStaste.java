package designpattern.state.v2;

/**
 * @author zcl
 * @date 2021/12/29 10:31
 */
public class MMNervousStaste extends MMState{
    @Override
    public void smile() {
        System.out.println("smile nervously");
    }

    @Override
    public void cry() {
        System.out.println("cry nervously");
    }

    @Override
    public void say() {
        System.out.println("say nervously");
    }
}
