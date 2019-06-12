package sync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author peirato.
 * @date 2019/6/13
 * @description:
 */
public class AtomicIntegetTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){
        return i.get();
    }
    private void evenIncrement(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void runTest(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegetTest ait = new AtomicIntegetTest();
        exec.execute(ait);
        while(true){
            int val = ait.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
    }
}


}
