package thread;

/**
 * @author peirato.
 * @date 2019/5/2722:57
 * @description:
 */
public class ThreadMain {

    public static void main(String... args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new PrintRunnable()).start();
        }


    }


}
