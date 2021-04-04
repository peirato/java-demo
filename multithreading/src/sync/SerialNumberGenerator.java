package sync;

/**
 * @author peirato.
 * @date 2019/6/12
 * @description:
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
//    public static synchronized int nextSerialNumber(){
    public static int nextSerialNumber(){
        return serialNumber ++;
    }
}
