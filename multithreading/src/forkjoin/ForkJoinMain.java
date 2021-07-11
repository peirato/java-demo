package forkjoin;

import java.util.concurrent.*;
import java.util.stream.IntStream;


public class ForkJoinMain {

    private static class SunTask extends RecursiveTask<Integer>{

        private int start;
        private int end;

        public SunTask(int start,int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if (end-start<=2) {
                int sum = 0;
                for (int i = start; i <= end; i++)
                    sum += i;
                return sum;
            }
            int middle = (end + start) / 2;
            SunTask leftTask = new SunTask(start,middle);
            SunTask rightTask = new SunTask(middle+1,end);
//            invokeAll(leftTask,rightTask);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }

    private static int sumByForeach(int start,int end){
        return IntStream.rangeClosed(start, end).sum();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 计算 1 - 1000000 累加
        int start=1,end=1000000;

        int result1 = sumByForeach(start,end);
        System.out.println("result1 = "+result1);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new SunTask(start,end));
        int result2 = forkJoinPool.invoke(task);
        System.out.println("result2 = "+result2);
//        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
//        forkJoinPool.shutdown();

    }


}
