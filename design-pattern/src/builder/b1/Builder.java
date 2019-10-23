package builder.b1;

/**
 * @author Yang zeqi
 * @date 2019/10/23
 * @description: 抽象建造者
 */
public interface Builder {

    public void buildPart1();

    public void buildPart2();

    public Product retrieveResult();

}
