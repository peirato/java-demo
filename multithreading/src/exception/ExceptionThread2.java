package exception;

/**
 * @author peirato.
 * @date 2019/6/11 23:19
 * @description:
 */
public class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by "+ t);
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
