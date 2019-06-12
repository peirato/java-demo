package exception;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author peirato.
 * @date 2019/6/11 23:09
 * @description:
 */
public class ExceptionMain {
    public static void main(String[] args) {
//        threadThrowException();
//        threadExceptionTryCatch();
//        captureUncaughtException();
        settingDefaultHandler();
    }

    /**
     * 在线程中抛出异常
     */
    public static void threadThrowException() {
        ExecutorService exce = Executors.newCachedThreadPool();
        exce.execute(new ExceptionThread());
    }

    /**
     * 使用try catch无法捕获线程中的异常
     */
    public static void threadExceptionTryCatch() {
        try {
            threadThrowException();
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled!");
        }

    }

    /**
     * 异常捕获
     */
    public static void captureUncaughtException() {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }

    /**
     * 设置默认异常捕获
     */
    public static void settingDefaultHandler(){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        threadThrowException();
    }

}
