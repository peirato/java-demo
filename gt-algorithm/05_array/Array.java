public class Array {

    private int capacity;
    private int[] array;
    private int currentIndex = 0;

    public Array(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int find(int find) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) {
                return i;
            }
        }

        return -1;
    }

    //
    public int insert(int i,int index) {

        if(index<capacity-1){

        }

    }
}
