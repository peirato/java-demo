package builder.b1;

/**
 * @author Yang zeqi
 * @date 2019/10/23
 * @description:
 */
public class Clinet {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(String.format("product[part1:%s,part2:%s]",product.getPart1(),product.getPart2()));
    }
}
