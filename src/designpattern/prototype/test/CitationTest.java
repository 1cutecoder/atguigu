package designpattern.prototype.test;

/**
 * @author zcl
 * @date 2021/12/8 17:32
 */
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("����");
        citation.setStudent(student);
        Citation clone = citation.clone();
        clone.getStudent().setName("����");
        citation.show();
        clone.show();
    }
}
