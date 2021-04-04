package sync;

/**
 * @author peirato.
 * @date 2019/6/11
 * @description:
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled()
    {
        return canceled;
    }
}
