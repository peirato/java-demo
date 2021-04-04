package exception;

/**
 * @author peirato.
 * @date 2019/6/11 23:21
 * @description:
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught "+ e);
    }
}
