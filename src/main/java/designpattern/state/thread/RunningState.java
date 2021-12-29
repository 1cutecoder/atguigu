package designpattern.state.thread;

/**
 * @author zcl
 * @date 2021/12/29 11:13
 */
public class RunningState extends ThreadState_ {
    private Thread_ t;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if ("terminated".equals(input.msg)) {
            t.state = new TerminatedState(t);
        }
    }

    @Override
    public void run() {

    }
}
