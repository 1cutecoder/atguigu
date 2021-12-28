package designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/12/28 16:36
 */
public class Main {
    public static void main(String[] args) {
        Content c = new Content();
        InsertCommand insertCommand = new InsertCommand(c);
        System.out.println(c.msg);
        insertCommand.doit();
        insertCommand.undoit();
        CopyCommand copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undoit();
        DeleteCommand deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undoit();
        System.out.println(c.msg);
        List<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(c));
        commands.add(new CopyCommand(c));
        commands.add(new DeleteCommand(c));
        System.out.println("do it start =========================");
        for (Command command : commands) {
            System.out.println(c.msg + "  ");
            command.doit();
        }
        System.out.println("do it end =========================");
        System.out.println("undo it start =========================");
        for (int i = commands.size()-1;  i >=0 ; i--) {
            System.out.println(c.msg + "  ");
            commands.get(i).undoit();
        }
        System.out.println("undo it end =========================");
        System.out.println(c.msg);
    }
}
