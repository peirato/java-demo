import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆 OOM 异常
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeepOOM {

    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>();

        while (true){
            list.add( new int[10000]);
//            list.add( new int[1]);
            System.out.println(list.size());
        }

    }

}