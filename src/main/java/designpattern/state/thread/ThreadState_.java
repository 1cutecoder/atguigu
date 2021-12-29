package designpattern.state.thread;

/**
 * @author zcl
 * @date 2021/12/29 11:11
 */
public abstract class ThreadState_ {

    public abstract void move(Action input);

    public abstract void run();
}
