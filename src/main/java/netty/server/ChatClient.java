package netty.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import netty.protocol.MessageCodec;

import java.net.InetSocketAddress;

/**
 * @author zcl
 * @date 2022/1/12 14:23
 */
@Slf4j
public class ChatClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOOGING_HANDLER = new LoggingHandler();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(LOOGING_HANDLER);
                    ch.pipeline().addLast(new MessageCodec());
                }
            });
            Channel channel = bootstrap.connect(new InetSocketAddress("localhost",8080)).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e){
            log.debug("client error exception:{}",e.toString());
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
