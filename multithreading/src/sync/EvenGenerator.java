package sync;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description:
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
}
