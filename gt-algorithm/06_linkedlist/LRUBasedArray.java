import java.util.HashMap;
import java.util.Map;

/**
 * 一个基于数组的LRU缓存
 */

public class LRUBasedArray<T> {

    private int capacity;

    private T[] value;

    private Map<T, Integer> holder;

    private int count;

    private static final int DEFAULT_CAPACITY = (1 << 3);

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        holder = new HashMap<>(capacity);
        count = 0;
    }


    /**
     * 访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("null ！");
        }

        Integer index = holder.get(object);
        //没有元素
        if (index == null) {
            //插入元素count
            if (isFull()) {
                //缓存已满
                removeAndCache(object);
            } else {
                //未满
                cache(object, count);
            }
        } else {
            //更新元素
            update(index);
        }

    }

    private void update(Integer index) {

        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);


    }

    private void removeAndCache(T object) {

        T key = value[--count];
        holder.remove(key);
        cache(object, count);

    }

    private boolean isFull() {
        return count == capacity;
    }

    /**
     * 缓存数据，要先右移
     *
     * @param object
     */
    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 右移
     *
     * @param end
     */
    private void rightShift(int end) {

        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i + 1], i + 1);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i =0;i<count;i++){
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
