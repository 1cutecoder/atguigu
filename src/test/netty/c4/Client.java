package netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/1/3 13:34
 */
public class Client {
    public static void main(String[] args) {
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("localhost", 8888));
            System.out.println("waiting");
        } catch (IOException e) {
                closeResource(channel);
            e.printStackTrace();
        } finally {
            closeResource(channel);
        }
    }

    private static void closeResource(SocketChannel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
