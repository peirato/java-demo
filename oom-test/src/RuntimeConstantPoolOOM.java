import java.util.HashSet;
import java.util.Set;

/**
 * 模拟运行时常量池 OOM 异常
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M -Xmx10M(JDK7之后)
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持常量池的引用
        Set<String> set  = new HashSet<>();
        int i = 0;

        while(true){
            set.add(String.valueOf(i++).intern());
            System.out.println(i);
        }

    }
}
