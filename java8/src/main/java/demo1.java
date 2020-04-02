import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Yang zeqi
 * @date 2020/3/24
 * @description:
 */
public class demo1 {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "OK";

        Predicate<Integer> positiveNumber = i -> i > 0;

        List list = Arrays.asList(1,2,3);
        String str = list.stream().collect(Collectors.joining(", ")).toString();


    }
}
