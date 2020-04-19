import java.awt.*;

/**
 * 单链表的常见操作
 */
public class SinglyLinkedList<T> {

    private Node<T> head = null;

    public T findByValue(T value) {
        Node p = head;
        while (p != null && !p.data.equals(value)) {
            p = p.next;
        }

        return (T) p.data;
    }

    public T findByIndex(int index) {
        Node p = head;
        int i = 0;
        while (p != null && i != index) {
            p = p.next;

            ++i;
        }

        return (T) p.data;
    }

    public void insertToHead(T value) {
        Node<T> newNode = new Node(value, null);

        insertToHead(newNode);
    }

    public void insertToHead(Node<T> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(T value) {

        Node<T> newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {

            Node<T> node = head;

            while (node.next != null) {
                node = node.next;
            }

            node.next = newNode;
        }
    }

    public void insertAfter(T value, T target) {

//        Node<T> node = head;
        Node<T> newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> node = head;
            while (node.next != null) {
                if (target.equals(node.data)) {
                    Node<T> oldNext = node.next;
                    node.next = newNode;
                    if (oldNext != null) {
                        newNode.next = oldNext;
                    }
                }

            }
        }


    }

    public void printAll() {

        Node n = head;
        while (n != null) {
            System.out.println(n.data.toString());
            n = n.next;
        }

    }

    //　判断是否为回文

    public boolean palindrome() {

        if (head == null) {
            return false;
        } else {

            //找到中间点

            Node p = head;
            Node q = head;

            if (head.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (q.next != null && q.next.next != null) {

                p = p.next;
                q = q.next.next;

            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                //节点数为奇数

                rightLink = p.next;
                leftLink = inverseLinkList(p).next;


            } else {
                //节点数为偶数

                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }


            printAll(leftLink);
            printAll(rightLink);


            return TFResult(leftLink, rightLink);


        }


    }

    private void printAll(Node n){
        System.out.println("打印：");
        if(n!=null){
            System.out.println(n.data);
        }
        while (n.next!=null){
            n = n .next;
            System.out.println(n.data);
        }
    }

    private boolean TFResult(Node leftLink, Node rightLink) {

        Node l = leftLink;
        Node r = rightLink;
        while (l != null && r != null) {
            if (l.data.equals(r.data)) {
                l = l.next;
                r = r.next;
            } else {
                return false;
            }
        }

        return true;


    }

    //无头节点的链表翻转
    private Node inverseLinkList(Node p) {
        System.out.println("翻转前节点");
        printAll(p);

        Node node = head;
        Node next;
        Node pre = null;

        while (node != p) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        node.next = pre;

        System.out.println("翻转后节点");
        printAll(node);
        return node;

    }


    public class Node<T> {

        private T data;

        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }

    }

    public static void main(String[] args) {

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
         int data[] = {1,2,5,2,1};
//        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
//            link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
