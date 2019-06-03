package inner;

/**
 * @author peirato.
 * @date 2019/5/29 21:55
 * @description: 使用匿名的Thread内部类
 */
public class InnerThread2 {

    private int countDown = 5;

    private Thread t;

    public static void print(Object object) {
        System.out.println(object);
    }

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {

                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return getName()+": " +countDown;
            }
        };
        t.start();
    }
}
