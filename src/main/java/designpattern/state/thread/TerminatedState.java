package designpattern.state.thread;

/**
 * @author zcl
 * @date 2021/12/29 11:13
 */
public class TerminatedState extends ThreadState_ {
    private Thread_ t;

    public TerminatedState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if ("new".equals(input.msg)) {
            t.state = new NewState(t);
        }
    }

    @Override
    public void run() {

    }
}
