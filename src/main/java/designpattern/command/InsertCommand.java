package designpattern.command;

/**
 * @author zcl
 * @date 2021/12/28 16:32
 */
public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.mashibing.com";

    @Override
    public void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undoit() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}
