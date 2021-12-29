package designpattern.state.thread;

/**
 * @author zcl
 * @date 2021/12/29 11:10
 */
public class Thread_ {
    ThreadState_ state;
    void move(Action input) {
        state.move(input);
    }
    void run (){
        state.run();
    }
}
