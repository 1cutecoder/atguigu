package designpattern.principles.LiscovSubstitution.after;

/**
 * @author zcl
 * @date 2021/11/29 16:26
 */
public class Computer {
    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;

    public void setHardDisk( HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setCpu( Cpu cpu) {
        this.cpu = cpu;
    }

    public void setMemory( Memory memory) {
        this.memory = memory;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Memory getMemory() {
        return memory;
    }
    public void run(){
        System.out.println("运行计算机");
        System.out.println("从硬盘上获取的数据：" + hardDisk.get());
        cpu.run();
        memory.save();
    }
}
