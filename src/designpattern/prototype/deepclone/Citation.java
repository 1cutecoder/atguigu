package designpattern.prototype.deepclone;

/**
 * @author zcl
 * @date 2021/12/8 17:30
 */
public class Citation implements Cloneable {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(student.getName() + "同学:在2021学年第一学期期中表现优秀,被评为三好学生.特发此状!");
    }

}
