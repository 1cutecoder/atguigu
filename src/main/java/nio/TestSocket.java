package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zcl
 * @date 2021/12/29 16:03
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        /**
         * socket==>3  -> bind(3,8090) -->listen(3)
         * while(true) accept(3,=5 ����
         * BIO һ���̶߳�Ӧһ������
         * ���ƣ����Խ��պܶ�����
         * ���ƣ��߳��ڴ��˷� cpu��������
         * ��Դ��Blocking ���� accept recv
         */
        ServerSocket server = new ServerSocket(8090);
        System.out.println("step1: new ServerSocket(8090) ");
        while (true) {
            Socket client = server.accept();
            System.out.println("step2:client \t" + client.getPort());
            new Thread((new Runnable() {
                Socket ss;

                public Runnable setSS(Socket s) {
                    ss = s;
                    return this;
                }

                @Override
                public void run() {
                    InputStream in = null;
                    try {
                        in = ss.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true) {
                            System.out.println(reader.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }), "").start();
        }
    }
}
