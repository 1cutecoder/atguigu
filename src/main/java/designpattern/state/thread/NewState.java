package designpattern.state.thread;

/**
 * @author zcl
 * @date 2021/12/29 11:13
 */
public class NewState extends ThreadState_{
    private Thread_ t;

    public NewState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if ("start".equals(input.msg)) {
            t.state = new RunningState(t);
        }
    }

    @Override
    public void run() {

    }
}
