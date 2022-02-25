package designpattern.state.v2;

/**
 * @author zcl
 * @date 2021/12/29 10:31
 */
public class MMHappyStaste extends MMState {
    @Override
    public void smile() {
        System.out.println("smile happily");
    }

    @Override
    public void cry() {
        System.out.println("cry happily");
    }

    @Override
    public void say() {
        System.out.println("say happily");
    }
}
