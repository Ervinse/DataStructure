package linearList.priorityQueue;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] obj;
    //保存每个元素在obj数组中的索引，objIndex数组需要堆有序
    private int[] objIndex;
    //保存objIndexReverse的逆序，objIndex的值作为索引，objIndex的索引作为值
    private int[] objIndexReverse;
    //记录堆中元素的个数
    private int count;


    public IndexMinPriorityQueue(int capacity) {
        this.obj = (T[]) new Comparable[capacity+1];
        this.objIndex = new int[capacity+1];
        this.objIndexReverse = new int[capacity+1];
        this.count = 0;

        //默认情况下，队列中没有存储任何数据，让objIndexReverse中的元素都为-1；
        for (int i = 0; i < objIndexReverse.length; i++) {
            objIndexReverse[i]=-1;
        }

    }

    //获取队列中元素的个数
    public int size() {
        return count;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return count ==0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {

        return obj[objIndex[i]].compareTo(obj[objIndex[j]])<0;
    }

    //交换堆中i索引和j索引处的值
    private void exchange(int i, int j) {
        //交换objIndex中的数据
        int tmp = objIndex[i];
        objIndex[i] = objIndex[j];
        objIndex[j] = tmp;


        //更新objIndexReverse中的数据
        objIndexReverse[objIndex[i]]=i;
        objIndexReverse[objIndex[j]] =j;

    }

    //判断k对应的元素是否存在
    public boolean contains(int k) {

        return objIndexReverse[k] !=-1;
    }

    //最小元素关联的索引
    public int minIndex() {

        return objIndex[1];
    }


    //往队列中插入一个元素,并关联索引index
    public void insert(int index, T obj) {
        //判断i是否已经被关联，如果已经被关联，则不让插入

        if (contains(index)){
            return;
        }
        //元素个数+1
        count++;
        //把数据存储到obj对应的i位置处
        this.obj[index] = obj;
        //把i存储到objIndex中
        objIndex[count] = index;
        //通过objIndexReverse来记录objIndex中的i
        objIndexReverse[index]= count;

        //通过堆上浮完成堆的调整

        swim(count);

    }

    //删除队列中最小的元素,并返回该元素关联的索引
    public int delMin() {
        //获取最小元素关联的索引
        int minIndex = objIndex[1];

        //交换objIndex中索引1处和最大索引处的元素
        exchange(1, count);
        //删除objIndexReverse中对应的内容
        objIndexReverse[objIndex[count]] = -1;
        //删除objIndex最大索引处的内容
        objIndex[count]=-1;
        //删除obj中对应的内容
        obj[minIndex] = null;
        //元素个数-1
        count--;
        //下沉调整
        sink(1);

        return minIndex;
    }

    //删除索引index关联的元素
    public void delete(int index) {
        //找到i在objIndex中的索引
        int k = objIndexReverse[index];

        //交换objIndex中索引k处的值和索引N处的值
        exchange(k, count);
        //删除objIndexReverse中的内容
        objIndexReverse[objIndex[count]] = -1;
        //删除objIndex中的内容
        objIndex[count]=-1;
        //删除obj中的内容
        obj[k]=null;
        //元素的数量-1
        count--;
        //堆的调整
        sink(k);
        swim(k);
    }

    //把与索引index关联的元素修改为为obj
    public void changeItem(int index, T obj) {
        //修改obj数组中index位置的元素为obj
        this.obj[index] = obj;
        //找到i在objIndex中出现的位置
        int k = objIndexReverse[index];
        //堆调整
        sink(k);
        swim(k);
    }


    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        while(k>1){
            if (less(k,k/2)){
                exchange(k,k/2);
            }

            k = k/2;
        }
    }


    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        while(2*k<= count){
            //找到子结点中的较小值
            int min;
            if (2*k+1<= count){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }else{
                    min = 2*k+1;
                }
            }else{
                min = 2*k;
            }
            //比较当前结点和较小值
            if (less(k,min)){
                break;
            }

            exchange(k,min);
            k = min;
        }
    }

}

