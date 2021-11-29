package designpattern.principles.demo3.before;

/**
 * @author zcl
 * @date 2021/11/29 16:26
 */
public class Computer {
    private XiJieHardDisk hardDisk;
    private IntelCpu cpu;
    private KingstonMemory memory;

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setCpu(IntelCpu cpu) {
        this.cpu = cpu;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public IntelCpu getCpu() {
        return cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }
    public void run(){
        System.out.println("运行计算机");
        System.out.println("从硬盘上获取的数据：" + hardDisk.get());
        cpu.run();
        memory.save();
    }
}
