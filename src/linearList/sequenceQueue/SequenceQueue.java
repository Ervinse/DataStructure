package linearList.sequenceQueue;

/**
 * 顺序循环队列
 * 约定当队尾指针+1等于队头指针，表示队列已满
 * 该队列最多只能存放 queueArray.length-1 个元素
 * @param <T>
 */
public class SequenceQueue<T> {

    final int MAXSIZE = 10;
    private T[] queueArray;
    private int front,rear;

    /**
     * 初始化队列
     */
    public SequenceQueue(){
        front = rear = 0;
        queueArray = (T[]) new Object[MAXSIZE];
    }

    /**
     * 入队
     * @param obj
     */
    public void enQueue(T obj){
        //当队列已满时，扩容
        if ((rear + 1) % queueArray.length == front){
            T[] temp = (T[]) new Object[queueArray.length * 2];
            //队尾指针在数组最后一位，即队头没有发生移动
            if (rear == queueArray.length - 1){
                //将值复制到新数组中
                for (int i = 1;i <= rear;i++){
                    temp[i] = queueArray[i];
                }
            //队尾指针不在数组最后一位队头发生移动
            }else {
                int i,j = 1;
                //将队头到数组最后一位之间到元素复制到新数组中
                for (i = front +1; i < queueArray.length; i++,j++) {
                    temp[j] = queueArray[i];
                //将数组最后一位到队尾之间到元素复制到新数组中
                }for (i = 0;i <= rear;i++,j++){
                    temp[j] = queueArray[i];
                }
                //新数组从头开始赋值，头指针指向数组0，队尾指针为原数组长度-1
                front = 0;
                rear = queueArray.length - 1;
            }
            queueArray = temp;
        }
        //队尾指针+1，添加元素
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = obj;
    }

    /**
     * 出队
     * @return
     */
    public T deQueue(){
        if (isEmpty()){
            System.out.println("队列已空，无法出队");
            return null;
        }
        front = (front + 1) % queueArray.length;
        return queueArray[front];
    }

    /**
     * 获取顶部元素
     * @return
     */
    public T getTop(){
        if (isEmpty()){
            System.out.println("队列已空，无法出队");
            return null;
        }
        return queueArray[(front + 1) % queueArray.length];
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 获取队列大小
     * @return
     */
    public int size(){
        return (rear - front + queueArray.length) % queueArray.length;
    }

    /**
     * 打印队列所有值
     */
    public void printValue(){
        int i,j = front;
        for (i = 1;i <= size();i++){
            j = (j + 1) % queueArray.length;
            System.out.print(queueArray[j] + " ");
        }
    }
}
