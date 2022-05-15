package exer;



/**
 * 每一个LinkedList有一个头节点，头节点不存储数据，指针指向下一个节点
 * 每向LinkedList添加一个数据，会创建一个next指针为空的节点Node来存储数据，并将上一个节点的next指针指向自己
 * 注意：本文档中的index表示"要执行的第index个数"，非数组中的索引
 * @param <T>   要插入的数据的类型
 */
public class LinkedList<T>{

    private Node<T> head;       //头节点
    private int length;         //长度

    /**
     * 初始化链表
     */
    public LinkedList(){
        length = 0;                         //长度置0
        head = new Node<T>(null);      //创建一个next指针为空的节点，并将头指针指向它
    }
    /**
     * 向链表添加数据
     * 每次添加数据从头指针开始根据next指针追踪数据，直到追踪到第length个节点
     * 创建一个新节点，存入数据，并将第length个节点的next指针指向新节点
     * @param obj   添加数据的值
     * @return  添加成功返回true，添加失败返回false
     */
    public boolean add(T obj){
        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num <= length){  //在length个数据之后添加数据

            //p，q指针右移
            p = q;
            q = q.next;
            num++;
        }
        //p指针指向节点存储的数据是最后一个数据
        //创建一个next指针为空的新节点，存入数据
        p.next = new Node<T>(obj,null);
        length++;
        return true;
    }


    /**
     * 从头部向链表添加数据
     * 创建一个指向头节点的next指针地址的节点(即第一个数地址)，并将头节点的next指针指向该节点
     * @param obj
     * @return
     */
    public boolean addBefore(T obj){
        head.next = new Node<T>(obj,head.next); //创建一个存储新数据的节点，该节点的next指针指向head.next
        length++;
        return true;
    }


    /**
     * 在index个位置前插入数据，q节点为index位置
     * @param index 插入数据的的位数
     * @param obj   插入数据的值
     * @return  插入成功返回true，插入失败返回false
     */
    public boolean insertBefore(int index,T obj){
        if (index < 1||index > length ){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index){    //在(index-1)个数据之后添加数据，即替换掉index个节点
            p = q;
            q = q.next;
            num++;
        }

        //创建一个新节点存储数据，将next指针指向原本被替换的节点，并将上一个节点的next指针指向自己
        p.next = new Node<T>(obj,q);
        length++;
        return true;
    }

    /**
     * 在index个位置后插入数据，q节点为index位置
     * @param index 插入数据的的位数
     * @param obj   插入数据的值
     * @return  插入成功返回true，插入失败返回false
     */
    public boolean insertAfter(int index,T obj){
        if (index < 1||index > length - 1){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index + 1){    //在(index-1)个数据之后添加数据，即替换掉index个节点
            p = q;
            q = q.next;
            num++;
        }

        //创建一个新节点存储数据，将next指针指向原本被替换的节点，并将上一个节点的next指针指向自己
        p.next = new Node<T>(obj,q);
        length++;
        return true;
    }


    /**
     * 表头插入
     * @param obj 插入的数值
     * @return 插入成功返回true，插入失败返回false
     */
    public boolean insertHead(T obj){
        head.next = new Node<T>(obj, head.next);
        length++;
        return true;
    }

    public boolean insertTail(T obj){
        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < length + 1){    //在(index-1)个数据之后添加数据，即替换掉index个节点
            p = q;
            q = q.next;
            num++;
        }

        //创建一个新节点存储数据，将next指针指向原本被替换的节点，并将上一个节点的next指针指向自己
        p.next = new Node<T>(obj,null);
        length++;
        return true;
    }

    /**
     * 查找值为obj的元素在从左向右第一次出现的位置
     * @param obj  要查找的数值
     * @return  返回该元素从左向右第一次出现的位置，如果没有查找到返回-1
     */
    public int select(T obj){
        if (isEmpty()){
            System.out.println("链表为空");
            return -1;
        }
        int num = 1;            //用于记录从头指针向后追踪数据的循环次数,每一次循环向后寻找一个元素，故该值也是当前比较元素的索引号
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据

        while (q != null){              //循环直到该节点的next指针指向null，即最后一个元素
            if(q.data.equals(obj)){     //判断每一个节点的数值是否为要查找的值
                break;                  //如果是要查找的值，跳出循环
            }
            q = q.next;                 //不是要查找的值，获取下一个节点
            num++;
        }
        if (q == null){                 //跳出循环后，如果q指针指向最后一个节点的next指针，说明没有查找到数值
            return -1;
        }
        return num;                     //返回查找的索引

    }

    /**
     * 修改第index位置的数值
     * @param index 要修改的数据的位数
     * @param obj   要修改的数据的值
     * @return  修改成功返回true，修改失败返回false
     */
    public boolean modify(int index,T obj){
        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        if (index < 1||index > length ){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }
        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index){
            q = q.next;
            num++;
        }//结束循环，q指针指向要修改的数据
        q.data = obj;   //修改数值
        return true;
    }

    /**
     * 删除索引值为index的数,index为q节点
     * @param index 要删除的数据的位数
     * @return  删除成功返回true，删除失败返回false
     */
    public boolean delete(int index){
        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        if (index < 1||index > length ){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index){
            p = q;
            q = q.next;
            num++;
        }//结束循环，p指针指向要删除数据的前一位，q指针指向要删除的数据
        p.next = q.next;        //将要删除数据的下一个节点的地址传给上一个节点的next指针，相当于跳过了这个值
        length--;               //链表长度-1
        return true;
    }

    /**
     * 删除索引值为index的后一个数,index为q节点
     * @param index 要删除的数据的位数
     * @return  删除成功返回true，删除失败返回false
     */
    public boolean deleteAfter(int index){
        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        if (index < 1||index > length - 1){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index + 1){
            p = q;
            q = q.next;
            num++;
        }//结束循环，p指针指向要删除数据的前一位，q指针指向要删除的数据
        p.next = q.next;        //将要删除数据的下一个节点的地址传给上一个节点的next指针，相当于跳过了这个值
        length--;               //链表长度-1
        return true;
    }


    /**
     * 删除索引值为index的前一个数,index为q节点
     * @param index 要删除的数据的位数
     * @return  删除成功返回true，删除失败返回false
     */
    public boolean deleteBefore(int index){
        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        if (index < 1||index > length){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < index - 1){
            p = q;
            q = q.next;
            num++;
        }//结束循环，p指针指向要删除数据的前一位，q指针指向要删除的数据
        p.next = q.next;        //将要删除数据的下一个节点的地址传给上一个节点的next指针，相当于跳过了这个值
        length--;               //链表长度-1
        return true;
    }

    /**
     * 删除表头节点
     * @return 删除成功返回true，删除失败返回false
     */
    public Boolean deleteHead(){
        head = head.next;
        length--;
        return true;
    }

    /**
     * 删除尾节点
     * @return 删除成功返回true，删除失败返回false
     */
    public Boolean deleteTail(){
        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }

        int num = 1;            //用于记录从头指针向后追踪数据的循环次数
        Node<T> p = head;       //p指针指向头指针
        Node<T> q = head.next;  //q指针指向头指针节点的next节点，即第一个数据（如果创建了的话）

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num < length){
            p = q;
            q = q.next;
            num++;
        }//结束循环，p指针指向要删除数据的前一位，q指针指向要删除的数据
        p.next = q.next;        //将要删除数据的下一个节点的地址传给上一个节点的next指针，相当于跳过了这个值
        length--;               //链表长度-1
        return true;
    }


    /**
     * 判断链表是否为空
     * @return  链表为空返回true，不为空返回false
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * 打印当前数组中的所有值
     */
    public void printValue(){
        int num = 1;
        Node<T> p = head;           //p指向头指针，是第0个节点
        Node<T> q = head.next;      //q指向头指针下一个节点，是第一个节点

        //每次循环后，索引为num的节点等于p节点（即num = p）
        while (num <= length){       //获取所有节点数据
            p = q;
            q = q.next;
            num++;

            System.out.print(p.getData() + " ");
        }
    }
}
