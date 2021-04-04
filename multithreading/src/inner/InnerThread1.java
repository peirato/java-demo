package inner;


/**
 * @author peirato.
 * @date 2019/5/29 21:28
 * @description: 使用命名的Thread内部类
 */
class InnerThread1 {

    private int countDown = 5;

    private InnerThread1.Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

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
                print("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}