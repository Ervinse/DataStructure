package linearList.linkStack;

public class LinkStack <T>{
    private Node<T> top;
    private int length;

    public LinkStack(){
        length = 0;
        top = null;
    }

    /**
     * 入栈
     * @param obj
     */
    public void push(T obj){
        top = new Node<T>(obj, top);
        length++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (isEmpty()){
            System.out.println("数据栈已经空");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 获取头元素
     * @return
     */
    public T getHead(){
        if (isEmpty()){
            System.out.println("数据栈已经空");
            return null;
        }
        return top.data;
    }

    /**
     * 获取当前栈长度
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == null;
    }

    /**
     * 遍历栈元素
     */
    public void printValue(){
        Node<T> p = top;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    /**
     * 清空栈
     */
    public void clear(){
        top = null;
    }
}
