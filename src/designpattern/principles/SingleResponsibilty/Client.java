package designpattern.principles.SingleResponsibilty;

/**
 * @author zcl
 * @date 2021/11/29 15:20
 */
public class Client {
    //����չ���ţ����޸Ĺر�
    public static void main(String[] args) {
        SougouImput sougouImput = new SougouImput();
        //DefaultSkin skin = new DefaultSkin();
        HeimaSkin skin = new HeimaSkin();
        sougouImput.setSkin(skin);
        sougouImput.dispaly();
    }
}
