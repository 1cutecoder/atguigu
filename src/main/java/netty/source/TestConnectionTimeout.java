package netty.source;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import netty.message.*;
import netty.protocol.MessageCodecSharable;
import netty.protocol.ProtocolFrameDecoder;
import netty.server.CommandType;

import java.net.InetSocketAddress;

/**
 * @author zcl
 * @date 2022/1/14 17:36
 */
@Slf4j
public class TestConnectionTimeout {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOOGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000);
            bootstrap.handler(LOOGING_HANDLER);
            Channel channel = bootstrap.connect(new InetSocketAddress("localhost", 8080)).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            log.debug("client error exception:{}", e.toString());
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
