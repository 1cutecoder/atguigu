package iodemo.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zcl
 * @date 2021/12/31 14:17
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress("127.0.0.1", 8888));
            while (true) {
                Socket s = ss.accept();
                new Thread(() -> {
                    handle(s);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handle(Socket s) {
        try {
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);
            System.out.println(new String(bytes, 0, len));
            s.getOutputStream().write(bytes, 0, len);
            s.getOutputStream().flush();
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
