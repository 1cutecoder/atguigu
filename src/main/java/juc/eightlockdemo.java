package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/9/22 10:06
 */
public class eightlockdemo {
    /**
     * ��һ��������������ж��synchronized������ĳһ��ʱ���ڣ�ֻҪһ���߳�ȥ�������е�һ��synchronized�����ˣ�
     * �������̶߳�ֻ�ܵȴ������仰˵��ĳһʱ���ڣ�ֻ����Ψһһ���߳�ȥ������Щsynchronized������
     * <p>
     * �������ǵ�ǰ����this���������������̶߳����ܽ��뵽��ǰ�����������synchronized������
     * <p>
     * �ۼӸ���ͨ�������ֺ�ͬ�����޹ء�
     * <p>
     * �ܻ��ɾ�̬ͬ������������ֱ仯
     * <p>
     * �����еķǾ�̬ͬ�������õĶ���ͬһ���� -- ʵ��������Ҳ����˵���һ��ʵ������ķǾ�̬ͬ��������ȡ����
     * ��ʵ������������Ǿ�̬ͬ����������ȴ���ȡ���ķ����ͷ�������ܻ�ȡ�������Ǳ��ʵ������ķǾ�̬ͬ��������Ϊ
     * ����ʵ������ķǾ�̬ͬ�������õ��ǲ�ͬ��������������ȴ���ʵ�������Ѿ�ȡ���ķǾ�̬ͬ�������ͷ����Ϳ��Ի�ȡ
     * �����Լ�������
     * <p>
     * �����еľ�̬ͬ�������õ�Ҳ��ͬһ���� -- �����������������������ͬ�Ķ������Ծ�̬ͬ��������Ǿ�̬ͬ��
     * ����֮�䲻���о�������������һ��һ����̬ͬ��������ȡ���������ľ�̬ͬ������������ȴ��÷����ͷ�������ܻ�
     * ȡ������������ͬһ��ʵ������ľ�̬ͬ������֮�䣬���ǲ�ͬ��ʵ������ľ�̬ͬ������֮�䣬ֻҪ������ͬһ��lei
     * ����
     */
    public static void main(String[] args) {
        Animal4 animal1 = new Animal4();
        Animal4 animal2 = new Animal4();

        new Thread(() -> {
            animal2.wuGui();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            animal2.tuZi();
        }).start();
    }
}

class Animal4 {

    public static synchronized void wuGui() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("�ڹ�����");
    }

    public synchronized void tuZi() {
        System.out.println("��������");
    }
}

