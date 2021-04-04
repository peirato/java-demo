package sync;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description:
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
       ++currentEvenValue;
       Thread.yield();
       ++currentEvenValue;
       return currentEvenValue;
    }
}
