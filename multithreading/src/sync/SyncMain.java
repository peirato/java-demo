package sync;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description:
 */
public class SyncMain {

    public static void main(String[] args) throws InterruptedException {
//        testEvenGenerator();
//        testSynchronizedEvenGenerator();
//        testMutexEvenGenerator();
//        testAttemptLocking();
//        testSerialNumber(args);
//        testAtomicInteger();
        testCriticalSection();

    }

    /**
     * 两种同步方式的效率比较
     */
    public static void testCriticalSection(){
        CriticalSection.run();
    }

    /**
     *  关于原子类
     */
    public static void testAtomicInteger(){
        AtomicIntegetTest.runTest();
    }

    /**
     * 关于 基本类型的原子操作
     * nextSerialNumber 方法不使用同步的话就会发现问题
     * @param args
     */
    public static void testSerialNumber(String[] args) throws InterruptedException {
        SerialNumberChecker.run(args);
    }

    /**
     * 使用显示锁进行尝试锁操作
     */
    public static void testAttemptLocking(){
        AttemptLocking.run();
    }

    /**
     *  使用显示锁
     */
    public static void testMutexEvenGenerator() {
        EvenChecker.test(new MutexEvenGenerator());
    }

    /**
     * 线程不安全
     */
    public static void testEvenGenerator() {
        EvenChecker.test(new EvenGenerator());
    }

    /**
     *  使用synchronized
     */
    public static void testSynchronizedEvenGenerator() {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }


}
