package netty.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static netty.c1.ByteBufferUtil.debugRead;

/**
 * 类描述
 *
 * @author zcl
 * @Description nio
 * @Date 2022/1/3 13:24
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
        ServerSocketChannel ssc = null;
        ByteBuffer buffer = ByteBuffer.allocate(16);
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(8888));
            List<SocketChannel> channels = new ArrayList<>();
            while (true) {
                log.info("connecting...");
                SocketChannel sc = ssc.accept();
                log.info("connected...{}" , sc);
                channels.add(sc);
                for (SocketChannel channel : channels) {
                    log.info("before read...{}",channel);
                    channel.read(buffer);
                    buffer.flip();
                    debugRead(buffer);
                    buffer.clear();
                    log.info("after read...{}",channel);
                }
            }
        } catch (IOException e) {
            closeResource(ssc);
            e.printStackTrace();
        } finally {
            closeResource(ssc);
        }

    }

    private static void closeResource(ServerSocketChannel ssc) {
        if (ssc != null) {
            try {
                ssc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
