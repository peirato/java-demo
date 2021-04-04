package thread;

/**
 * @author peirato.
 * @date 2019/5/27 23:03
 * @description:
 */
public class PrintRunnable implements Runnable {

    private static int i = 0 ;

    private final int num = i;

    public PrintRunnable() {
        i++;
        System.out.println("runnable "+num+" is started on " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(num+" - "+System.currentTimeMillis());
            Thread.yield();
        }
    }
}
