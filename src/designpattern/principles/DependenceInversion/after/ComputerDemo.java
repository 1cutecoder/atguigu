package designpattern.principles.DependenceInversion.after;


/**
 * @author zcl
 * @date 2021/11/29 16:30
 */
public class ComputerDemo {
    public static void main(String[] args) {
        HardDisk hardDisk = new XiJieHardDisk();
        Cpu cpu = new IntelCpu();
        Memory memory = new KingstonMemory();
        Computer computer = new Computer();
        computer.setCpu(cpu);
        computer.setHardDisk(hardDisk);
        computer.setMemory(memory);
        computer.run();
    }
}
