package inner;

import java.util.concurrent.TimeUnit;

/**
 * @author peirato.
 * @date 2019/5/29 22:09
 * @description: 使用匿名Runnable内部类
 */
public class InnerRunnable2 {
    private int coundDown = 5;
    private Thread t;

    public static void print(Object object) {
        System.out.println(object);
    }

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--coundDown == 0) {
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
                return Thread.currentThread().getName() +": "+coundDown;
            }
        },name);
        t.start();

    }
}
