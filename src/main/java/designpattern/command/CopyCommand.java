package designpattern.command;

/**
 * @author zcl
 * @date 2021/12/28 16:37
 */
public class CopyCommand  extends Command{
    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + c.msg;
    }

    @Override
    public void undoit() {
       c.msg =  c.msg.substring(0,c.msg.length()/2);
    }
}
