package linearList.sequenceStack;

public class SequenceStack <T>{

    final int MAXSIZE = 10;
    private T[] stackArray;
    private int top;            //指向栈定元素定指针

    public SequenceStack() {

        top = -1;
        stackArray = (T[]) new Object[MAXSIZE];
    }

    public SequenceStack(int n) {
        if (n < 1){
            System.out.println("栈长度不能低于1");
            stackArray = (T[]) new Object[MAXSIZE];
        }else {
            stackArray = (T[]) new Object[n];
            top = -1;
        }
    }

    /**
     * 入栈
     * @param obj
     */
    public void push(T obj){
        if (top == stackArray.length - 1){
            T[] tmp = (T[]) new Object[top * 2 + 2];
            for (int i = 0;i < top + 1;i++){
                tmp[i] = stackArray[i];
            }
            stackArray = tmp;
        }
        top++;
        stackArray[top] = obj;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (isEmpty()){
            System.out.println("数据栈已空，无法删除元素");
            return null;
        }
        top--;
        return stackArray[top + 1];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public T getHead(){
        if (isEmpty()){
            System.out.println("数据栈已经空，无法获取元素");
            return null;
        }
        return stackArray[top];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 获取栈长度
     * @return
     */
    public int gerSize(){
        return top + 1;
    }

    /**
     * 遍历栈
     */
    public void printValue(){
        for (int i = top; i > -1; i--) {
            System.out.print(stackArray[i] + " ");
        }
    }

    /**
     * 清空栈
     */
    public void clear(){
        top = -1;
    }
}
