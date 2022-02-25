package designpattern.principles.DependenceInversion.before;

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

    public void run() {
        System.out.println("���м����");
        System.out.println("��Ӳ���ϻ�ȡ�����ݣ�" + hardDisk.get());
        cpu.run();
        memory.save();
    }
}
