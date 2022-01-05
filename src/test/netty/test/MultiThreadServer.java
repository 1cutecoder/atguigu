package netty.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static netty.c1.ByteBufferUtil.debugAll;

/**
 * @author zcl
 * @date 2022/1/4 16:40
 */
@Slf4j
public class MultiThreadServer {
    public static void main(String[] args) {
        Thread.currentThread().setName("Boss");
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(8080));
            Selector boss = Selector.open();
            SelectionKey bossKey = ssc.register(boss, 0, null);
            bossKey.interestOps(SelectionKey.OP_ACCEPT);
            Worker worker = new Worker("worker-0");
            while (true) {
                boss.select();
                Iterator<SelectionKey> iterator = boss.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        log.info("connected...{}", sc.getRemoteAddress());
                        log.info("before register...{}", sc.getRemoteAddress());
                        worker.register();
                        sc.register(worker.selector, SelectionKey.OP_READ, null);
                        log.info("after register...{}", sc.getRemoteAddress());
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


    static class Worker implements Runnable {
        private Thread thread;
        private Selector selector;
        private String name;
        private volatile boolean start = false;

        public Worker(String name) {
            this.name = name;
        }

        public void register() {
            if (!start) {
                synchronized (this) {
                    if (!start) {
                        try {
                            selector = Selector.open();
                            thread = new Thread(this, name);
                            thread.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        start = true;
                    }
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel sc = (SocketChannel) key.channel();
                            log.info("read...{}",sc.getRemoteAddress());
                            int read = sc.read(buffer);
                            if (read == -1) {
                                key.cancel();
                            }
                            buffer.flip();
                            debugAll(buffer);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
