package designpattern.principles.Demeter;

/**
 * @author zcl
 * @date 2021/12/1 14:39
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //�ͷ�˿����
    public void meeting() {
        System.out.println(star.getName() + "�ͷ�˿" + fans.getName() + "����");
    }

    //��ý�幫˾Ǣ̸
    public void business() {
        System.out.println(star.getName() + "��" + company.getName() + "Ǣ̸");
    }
}
