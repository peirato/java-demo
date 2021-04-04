import java.util.Scanner;

/**
 * 基于单链表LRU算法
 */
public class LRUBaseLinkedList<T> {


    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头节点
     */
    private SNode<T> headNode;

    private Integer capacity;

    private Integer length;

    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;

    }

    public void add(T data) {
        //判断元素是否存在
        SNode preNode = findPreNode(data);

        //存在就将原数据删除，然后插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //如果链表已满 删除尾节点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }

        //不存在判断链表长度是否到上限

        //没到将数据设为第一个元素

        // 到了就删除最后一个元素，然后将数据设置为第一个元素


    }

    private void deleteElemAtEnd() {
        SNode sNode = headNode;
        //空链表直接返回
        if (sNode.getNext() == null) {
            return;
        }

        //找到倒数第二个节点
        while (sNode.getNext().getNext() == null) {
            sNode = sNode.getNext();
        }

        SNode temp = sNode.getNext();
        sNode.setNext(null);
        temp = null;
        length--;


    }

    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        SNode sNode = new SNode(data, next);
        headNode.setNext(sNode);
        length++;
    }

    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;

    }

    /**
     * 找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }

            node = node.getNext();
        }

        return null;
    }

    private void printAll(){
        SNode node = headNode.getNext();
        while(node!=null){
            System.out.print(node.getElement()+",");
            node = node.getNext();
        }
        System.out.println();
    }



    public class SNode<T> {
        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
