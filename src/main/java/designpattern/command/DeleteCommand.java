package designpattern.command;

/**
 * @author zcl
 * @date 2021/12/28 16:36
 */
public class DeleteCommand extends Command {
    Content c;
    String strToDelete = "";

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        this.strToDelete = c.msg;
        c.msg = "";
    }

    @Override
    public void undoit() {
        c.msg = strToDelete;
    }
}
