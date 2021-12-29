package designpattern.state.v1;

/**
 * @author zcl
 * @date 2021/12/29 10:23
 */
public class MM {
    String name;

    private enum MMState {HAPPY, SAD}

    MMState state;

    public void smile() {
        System.out.println("happy");
    }

    public void cry() {
    }

    public void say() {
    }

}
