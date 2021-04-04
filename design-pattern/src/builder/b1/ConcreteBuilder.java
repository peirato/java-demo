package builder.b1;

/**
 * @author Yang zeqi
 * @date 2019/10/23
 * @description: 具体建造者
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
