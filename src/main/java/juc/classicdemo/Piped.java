package juc.classicdemo;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author zcl
 * @date 2022/5/17 15:31
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printerThread = new Thread(new Printer(in), "PrinterThread");
        printerThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Printer implements Runnable {
        private PipedReader in;

        public Printer(PipedReader in) {
            this.in = in;

        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char)receive);
                }
            } catch (IOException e) {

            }
        }
    }
}
