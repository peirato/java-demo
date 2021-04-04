package builder.b1;

/**
 * @author Yang zeqi
 * @date 2019/10/23
 * @description: 导演者
 */
public class Director {

    private Builder builder ;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
