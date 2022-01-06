package netty.c3;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/1/6 10:44
 */
@Slf4j
public class TestEventLoop {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println("submit---------------------------------------------------------------------------------------------------------------");
        //3.执行普通任务
       /* log.info("main");
        group.next().execute(() ->{
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
           log.info("ok");
        });*/
        //4.执行定时任务
        group.next().scheduleAtFixedRate(()->{
            log.info("ok");
        },0,1,TimeUnit.SECONDS);
    }
}
