package linearList.linkQueue;

/**
 * 链队列
 * @param <T>
 */
public class LinkQueue <T>{

    private Node<T> front,rear;
    private int length;

    /**
     * 初始化链队列
     */
    public LinkQueue() {
        length = 0;
        front = rear = new Node<>(null);
    }

    /**
     * 入队
     * @param obj
     */
    public void enQueue(T obj){
        rear = rear.next = new Node<T>(obj, null);
        length++;
    }

    /**
     * 出队
     * @return
     */
    public T deQueue(){
        if (isEmpty()){
            System.out.println("队列已满，无法出队");
        }
        Node<T> p = front.next;
        T data = p.data;
        front.next = p.next;
        length--;
        if (front.next == null){
            rear = front;
        }
        return data;
    }

    /**
     * 获取头元素
     * @return
     */
    public T getHead(){
        if (isEmpty()){
            System.out.println("队列已满，无法出队");
        }
        return front.next.data;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front.next == null;
    }

    /**
     * 打印队列元素
     */
    public void printValue(){
        Node<T> p = front.next;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    /**
     * 清空队列
     */
    public void clear(){
        front.next = rear.next = null;
    }
}
