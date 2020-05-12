package java8.src.main.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamDemo {


    public static void main(String[] args) {



        Arrays.stream(new User[]{new User(),new User()})
                .filter(user -> user.type==1)
                .sorted(Comparator.comparingInt(a -> a.sort))
                // peek被推荐为在debug中使用
                .peek(user -> user.status=1)
                .forEach(user -> {});
    }


    static class User{
        private int sort;

        private int type;

        private int status;
    }
}
