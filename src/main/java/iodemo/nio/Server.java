package iodemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zcl
 * @date 2021/12/31 14:40
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    handle(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            ssc.close();
        }
    }

    private static void handle(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel ssc =null;
            try {
                ssc =  (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(key.selector(),SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
                ssc.close();
            }
        } else if (key.isReadable()) {
            SocketChannel sc =null;
            try {
                sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
               buffer.clear();
                int len = sc.read(buffer);
                if (len != -1) {
                    System.out.println(new String(buffer.array(),0,len));
                }
                ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
                sc.write(bufferToWrite);
            } catch (IOException e) {
                e.printStackTrace();
                sc.close();
            } finally {
                sc.close();
            }
        }
    }
}
