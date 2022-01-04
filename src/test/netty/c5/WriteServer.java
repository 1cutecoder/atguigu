package netty.c5;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author zcl
 * @date 2022/1/4 15:47
 */
@Slf4j
public class WriteServer {
    public static void main(String[] args) {
        ServerSocketChannel ssc = null;
        Selector selector =null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            ssc.bind(new InetSocketAddress(8080));
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < 30_000_000; i++) {
                            sb.append("a");
                        }
                        ByteBuffer buffer = Charset.defaultCharset().encode(sb.toString());
                        while (buffer.hasRemaining()) {
                            int write = sc.write(buffer);
                            System.out.println("write = " + write);

                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
