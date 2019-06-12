package exception;

/**
 * @author peirato.
 * @date 2019/6/11 23:09
 * @description:
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
