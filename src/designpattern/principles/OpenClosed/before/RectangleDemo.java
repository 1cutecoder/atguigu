package designpattern.principles.OpenClosed.before;

/**
 * @author zcl
 * @date 2021/11/29 15:38
 */
public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        resize(rectangle);
        printLengthAndWidth(rectangle);
        System.out.println("===================================");
        Square square = new Square();
        square.setWidth(10);
        resize(square);
        printLengthAndWidth(square);
    }

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println("rectangle.getLength() = " + rectangle.getLength());
        System.out.println("rectangle.getWidth() = " + rectangle.getWidth());
    }

}
