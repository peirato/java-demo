/**
 * 数组
 * @param <T>
 */
public class GenericArray<T> {

    private T[] data;
    private int size;


    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean set(int index, T e) {
        if (checkIndex(index)) {
            data[index] = e;
            return true;
        }

        return false;

    }

    public T get(int index) {
        checkIndex(index);
        return data[index];

    }

    public boolean contains(T e) {
        for (T d : data) {
            if (e.equals(d)) {
                return true;
            }
        }

        return false;
    }

    public int find(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public void add(int index, T e) {
        checkIndex(index);
        if (size == data.length) {
            resize(size * 2);
        }

//        for(int i=index;i<size;i++){
//            data[i+1] = data[i];
//        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }

    public T remove(int index){
        checkIndex(index);

        T e = data[index];

        for(int i = index;i<size-1;i++){
            data[index] = data[index+1];
        }
        size--;

        return e;

    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

    }

    private boolean checkIndex(int index) {
        if (index > 0 && index < size) {
            return true;
        }
        throw new IllegalArgumentException("");
    }


    public static void main(String[] args) {
        //TODO
    }
}
