package iodemo.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author zcl
 * @date 2021/12/31 14:09
 */
public class Client {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 8888);
            s.getOutputStream().write("HelloServer".getBytes());
            s.getOutputStream().flush();
            System.out.println("write over,waiting for msg back...");
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);
            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
            closeResource(s);
        }
    }
   private static void closeResource(Socket s) {
        if (s != null) {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
