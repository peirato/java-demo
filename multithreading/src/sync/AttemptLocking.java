package sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description: 显示锁2,尝试获取锁
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS):"+captured);
        } finally {
            if (captured){
                lock.unlock();
            }
        }

    }

    public static void run(){
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
        //TODO 和预期结果不同
    }
}
