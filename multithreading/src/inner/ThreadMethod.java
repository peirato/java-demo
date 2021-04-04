package inner;

/**
 * @author peirato.
 * @date 2019/5/29 22:14
 * @description: 使用方法来运行一个线程
 */
public class ThreadMethod {

    private int countDown = 5;

    private Thread t;

    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public static void print(Object object) {
        System.out.println(object);
    }

    public void runTask() {
        if (t == null) {
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
                        e.printStackTrace();
                    }
                }

                @Override
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
}
