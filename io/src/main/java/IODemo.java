import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

/**
 * @author Yang zeqi
 * @date 2020/4/16
 * @description:
 */
public class IODemo {

    public static void main(String[] args) throws IOException {

        readAllLines();

        readLines();

        bufferedStreamBufferOperation();

        fileChannelOperation();

    }

    // 读取全部 不推荐 如果文件太长，会一次性把所有内容读到内存中，引发oom
    private static void readAllLines() throws IOException{
        Files.readAllLines(Paths.get("demo.txt"));
    }

    // 一次读一行，按需读取 不会引发oom 但是要注意资源回收
    private static void readLines() throws IOException{

        try (Stream<String> lines = Files.lines(Paths.get("demo.txt"))){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用缓冲流+缓冲区读写文件（效率最高）
    private static void bufferedStreamBufferOperation() throws IOException{
        Files.deleteIfExists(Paths.get("dest.txt"));

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src.txt"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dest.txt"))) {
            byte[] buffer = new byte[8192];
            int len;
            while((len = bufferedInputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,len);
            }
        }

    }

    // 对于类似的文件复制操作，如果希望有更高性能，
    // 可以使用 FileChannel 的 transfreTo 方法进行流的复制。
    // 在一些操作系统（比如高版本的 Linux 和 UNIX）上可以实现 DMA（直接内存访问），
    // 也就是数据从磁盘经过总线直接发送到目标文件，无需经过内存和 CPU 进行数据中转：
    private static void fileChannelOperation() throws IOException{
        Files.deleteIfExists(Paths.get("dest.txt"));

        FileChannel in = FileChannel.open(Paths.get("src.txt"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("desc.txt"),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        in.transferTo(0,in.size(),out);
    }


}
