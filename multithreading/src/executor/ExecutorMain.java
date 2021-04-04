package executor;

import thread.PrintRunnable;

import java.util.concurrent.*;

/**
 * @author peirato.
 * @date 2019/5/27 23:13
 * @description:
 */
public class ExecutorMain {

    public static void main(String... args) throws ExecutionException, InterruptedException {
//        runCachedThreadPool();
//        runFixedThreadPool();
//        runSingleThreadExecutor();
//        runCallable();
        runThreadDemo();

    }

    public static void runCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new PrintRunnable());
        }
        executorService.shutdown();
    }

    public static void runFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new PrintRunnable());
        }
        executorService.shutdown();
    }

    public static void runSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new PrintRunnable());
        }
        executorService.shutdown();
    }

    public static void runCallable() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> result1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 3;
            }
        });
        Future<Integer> result2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 7;
            }
        });

        executorService.shutdown();

        long start = System.currentTimeMillis();

        int i1 = result1.get();
        int i2 = result2.get();

        long end = System.currentTimeMillis();
        System.out.println(i1 + " + " + i2 + " = " + (i1 + i2));
        System.out.println("Intervals :" + (end-start)/1000+"s");
    }

    public static void runThreadDemo() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        Thread.currentThread().setPriority(2);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
    }
}
