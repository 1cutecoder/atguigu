package netty.server.session;

import java.nio.channels.Channel;

/**
 * @author zcl
 * @date 2022/1/12 13:51
 */
public interface Session {
    void bind(Channel channel, String username);

    void unbind(Channel channel);

    Object getAttribute(Channel channel,String name);

    Object setAttribute(Channel channel, String name, String value);

    Channel getChannel(String username);
}
