package inner;

/**
 * @author peirato.
 * @date 2019/5/29 21:28
 * @description:
 */
public class Main {
    public static void main(String... args) {

        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
        
    }


}



