package designpattern.principles.demo2.after;

/**
 * @author zcl
 * @date 2021/11/29 16:00
 */
public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        resize(rectangle);
        printLengthAndWidth(rectangle);
        System.out.println("======================================");
        Square square = new Square();

    }

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Quadrilateral quadrilateral) {
        System.out.println("quadrilateral.getLength() = " + quadrilateral.getLength());
        System.out.println("quadrilateral.getWidth() = " + quadrilateral.getWidth());
    }
}
