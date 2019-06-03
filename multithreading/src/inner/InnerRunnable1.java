package inner;

import java.util.concurrent.TimeUnit;

/**
 * @author peirato.
 * @date 2019/5/29 22:01
 * @description: 使用命名的Runnable内部类
 */
public class InnerRunnable1 {
    private int countDown = 5;

    private Inner inner;

    public static void print(Object object) {
        System.out.println(object);
    }

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    print(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return t.getName()+": " + countDown;
        }

    }

    public InnerRunnable1(String name){
        inner = new Inner(name);
    }
}
