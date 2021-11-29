package designpattern.principles.demo3.before;

/**
 * @author zcl
 * @date 2021/11/29 16:30
 */
public class ComputerDemo {
    public static void main(String[] args) {
        XiJieHardDisk hardDisk = new XiJieHardDisk();
        IntelCpu cpu = new IntelCpu();
        KingstonMemory memory = new KingstonMemory();
        Computer computer = new Computer();
        computer.setCpu(cpu);
        computer.setHardDisk(hardDisk);
        computer.setMemory(memory);
        computer.run();
    }
}
