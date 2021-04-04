package exception;

import java.util.concurrent.ThreadFactory;

/**
 * @author peirato.
 * @date 2019/6/11 23:22
 * @description:
 */
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread();
        System.out.println("created "+ t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("en = "+t.getUncaughtExceptionHandler());
        return t;
    }
}
