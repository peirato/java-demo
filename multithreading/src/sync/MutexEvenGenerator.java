package sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description: 显示锁
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        try {
            lock.lock();
            ++ currentValue;
            Thread.yield();
            ++ currentValue;
            return currentValue;
        }  finally {
            lock.unlock();
        }
    }
}
