package jvm;

/**
 * @author zcl
 * @date 2021/10/15 14:33
 */
public class DynamicLinkingTest {
    int num = 10;
    public void methodA(){
        System.out.println("methodA().....");
    }
    public void methodB(){
        System.out.println("methodB().....");
        methodA();
        num ++;
    }
}
