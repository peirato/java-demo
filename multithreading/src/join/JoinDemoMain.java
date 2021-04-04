package join;

/**
 * @author peirato.
 * @date 2019/6/11 22:47
 * @description:
 */
public class JoinDemoMain {

    public static void main(String [] args){
        Sleeper sleepy = new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleepy),
                doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }



    public  static void print(Object obj){
        System.out.println(obj);
    }


}
