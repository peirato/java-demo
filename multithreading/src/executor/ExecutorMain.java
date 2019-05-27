package executor;

import thread.PrintRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author peirato.
 * @date 2019/5/2723:13
 * @description:
 */
public class ExecutorMain {

    public static void main(String... args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new PrintRunnable());
        }
        executorService.shutdown();
    }
}
