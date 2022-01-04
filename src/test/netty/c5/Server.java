package netty.c5;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static netty.c1.ByteBufferUtil.debugRead;

/**
 * @author zcl
 * @date 2022/1/4 12:34
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1 << 4);
        ServerSocketChannel ssc = null;
        Selector selector = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(8080));
            selector = Selector.open();
            SelectionKey sscKey = ssc.register(selector, 0, null);
            sscKey.interestOps(SelectionKey.OP_ACCEPT);
            log.info("register key:{}", sscKey);
            while (true) {
                selector.select();
                //包含了所有发生的事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    log.info("key:{}", key);
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel sc = channel.accept();
                        sc.configureBlocking(false);
                        SelectionKey sckey = sc.register(selector, 0, null);
                        sckey.interestOps(SelectionKey.OP_READ);
                        log.info("{}", sc);
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        channel.read(buffer);
                        buffer.flip();
                        debugRead(buffer);
                    }
                }
            }
        } catch (IOException e) {
            closeResource(ssc);
            e.printStackTrace();
        } finally {
            closeResource(ssc);
        }

    }


    public static void closeResource(ServerSocketChannel ssc) {
        if (ssc != null) {
            try {
                ssc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
