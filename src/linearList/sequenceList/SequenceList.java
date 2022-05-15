package linearList.sequenceList;

public class SequenceList <T>{

    private final int MaxSize = 10;     //初始化数组长度
    private T[] listArray;      //实际存储元素
    private int length;         //当前数组长度

    /**
     * 默认初始化顺序表，长度为10
     */
    public SequenceList() {

        length = 0;     //初始化长度
        listArray = (T[]) new Object[MaxSize];      //建立长度为10的数组
    }

    /**
     * 根据传入的长度，初始化顺序表
     * @param n
     */
    public SequenceList(int n){
        if (n <= 0){
            System.out.println("顺序表长度不能小于0");
        }else {
            length = 0;     //初始化长度
            listArray = (T[]) new Object[n];        ////建立长度为n的数组
        }
    }

    /**
     * 根据length数值判断顺序表是否为空
     * @return
     */
    private boolean isEmpty(){
        return length == 0;
    }

    /**
     * 添加一个数据
     * @param obj
     * @return
     */
    public boolean add(T obj){
        if (length == listArray.length){                 //要添加的位置为最后一位
            T[] p  = (T[]) new Object[length * 2];       //建立一个两倍于当前数组长度
            for (int i =length;i < length;i++){
                p[i] = listArray[i];                     //将原本的数据传入新创建的数组中
            }
            listArray = p;
        }

        listArray[length] = obj;
        length++;
        return true;
    }

    /**
     * 根据顺序表索引位置，插入一个数据
     * @param index
     * @param obj
     * @return
     */
    public boolean insert(int index,T obj){
        if (index < 1 || index > length + 1){
            System.out.println("索引值不能小于1或大于当前数组长度");
            return false;       //插入不成功
        }else if (length == listArray.length){           //要插入的位置为最后一位
            T[] p  = (T[]) new Object[length * 2];       //建立一个两倍于当前数组长度
            for (int i =length;i < length;i++){
                p[i] = listArray[i];                     //将原本的数据传入新创建的数组中
            }
            listArray = p;                                //将新数组地址传给listArray
        }

        //从最后一位开始向后移动一位，直到要插入位置index移动到index+1
        for (int i = length;i >= index;i--){
            listArray[i] = listArray[i - 1];
        }

        listArray[index - 1] = obj;       //将要插入到数据保存到index位置
        length++;                       //顺序表长度+1
        return true;                    //插入成功
    }


    /**
     * 根据顺序表索引位置，删除一个数据
     * @param index
     * @return
     */
    public boolean remove(int index){

        //判断是否为空表
        if (isEmpty()){
            System.out.println("顺序表为空，无法删除数据");
            return false;   //删除失败
        } else {

            //索引位置不合法
            if (index < 1||index > length){
                System.out.println("索引值不能小于1或大于当前数组长度");
                return false;       //删除失败
            }

            //从index位置开始，将index+1到数值保存到index，直到数组末尾
            for (int i = index;i <= length;i++){
                listArray[i - 1] = listArray[i];
            }
            length--;       //当前顺序表长度-1
            return true;    //删除成功
        }
    }


    /**
     * 根据索引获取顺序表存储数值
     * @param index
     * @return
     */
    public T getValue(int index){

        //判断是否为空表
        if (isEmpty()){
            System.out.println("顺序表为空，无法读取数据");
            return null;
        }else {

            //索引位置不合法
            if (index < 1||index > length){
                System.out.println("索引值不能小于1或大于当前数组长度");
                return null;       //读取失败
            }

            return listArray[index - 1];

        }
    }

    /**
     * 根据索引位置替换顺序表存储数值
     * @param index
     * @param obj
     * @return
     */
    public boolean modify(int index,T obj){

        //判断是否为空表
        if (isEmpty()){
            System.out.println("顺序表为空，无法读取数据");
            return false;
        }else {

            //索引位置不合法
            if (index < 1 || index > length) {
                System.out.println("索引值不能小于1或大于当前数组长度");
                return false;       //修改失败
            }

            //将index位置上到元素改为obj
            listArray[index -1] = obj;
            return true;

        }
    }

    /**
     * 打印顺序表中的数值
     */
    public void printValue(){
        for (int i = 0;i < length;i++){
            System.out.print(listArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * 获取顺序表中的数值
     * @return
     */
    public T[] getValue(){
        return listArray;
    }







}
