package juc.darkhorse;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * @author zcl
 * @date 2022/6/6 14:26
 * 保护性暂停
 */
@Slf4j
public class ProtectPauseTest {
    public static void main(String[] args) {
        //线程1等待线程2的下载结果
        GuardedObject guardedObject = new GuardedObject();
        new Thread(() -> {
            log.debug("等待结果");
            List list = (List) guardedObject.get();
            log.debug("" + list.size());
        }, "t1").start();
        new Thread(() -> {
            log.debug("执行下载");
            List<String> list = null;
            try {
                list = DownLoader.download();
            } catch (IOException e) {
                e.printStackTrace();
            }
            guardedObject.complete(list);
        }, "t2").start();
    }
}

class GuardedObject {
    private Object response;

    public Object get() {
        synchronized (this) {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
