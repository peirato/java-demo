package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author peirato.
 * @date 2019/6/11
 * @description:
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp,int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
