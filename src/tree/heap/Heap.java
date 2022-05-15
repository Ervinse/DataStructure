package tree.heap;

/**
 * 堆
 * @param <T> 堆中元素的类型
 */
public class Heap <T extends Comparable<T>>{

    //存储堆中的元素
    private T[] data;
    //记录堆中元素的个数
    private int size;

    /**
     * 创建一个容量为capacity的堆
     * @param capacity
     */
    public Heap(int capacity) {
        //堆从data[1]开始存储数据,故实际存储元素的数组为data[capacity+1]
        this.data = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    /**
     * 判断堆中元素i是否小于j
     * @param i 判断的第一个元素
     * @param j 判断的第二个元素
     * @return 小于返回true,大于返回false
     */
    private boolean less(int i,int j){
        return data[i].compareTo(data[j]) < 0;
    }

    /**
     * 交换堆中元素i和j
     * @param i 交换的第一个元素
     * @param j 交换的第二个元素
     */
    private void exchange(int i,int j){
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 向堆中插入一个元素
     * @param obj 插入的元素
     */
    public void insert(T obj){
        data[++size] = obj;
        swim(size);
    }

    /**
     * 使用上浮算法,使索引在location位置的元素在堆中出于一个正确的位置
     * @param index 要检查的元素的索引
     */
    private void swim(int index){

        //从此元素开始,向上依次检查父元素,直至根元素
        while (index > 1){
            //比较该元素的值和其父元素的值
            if (less(index/2,index)){
                //如果其父元素的值小于该元素的值,则交换它们的位置
                exchange(index/2,index);
                //将检查元素除以2,检查其父元素
                index = index/2;
            }else {
                //如果其元素点的值大于该元素的值,则该元素位置正确,无需检查其上的元素
                break;
            }
        }
    }

    /**
     * 删除堆中最大的元素,并返回这个最大的元素
     * @return 被删除的堆中最大元素的值
     */
    public T deleteMax(){
        if (size < 1){
            System.out.println("堆为空,无法删除最大元素");
            return null;
        }
        //记录最大的元素
        T maxValue = data[1];
        //交换最大的元素和最后一个元素
        exchange(1,size);
        //删除最后一个元素
        data[size] = null;
        //元素个数-1
        size--;
        //通过下沉算法,将刚放入索引位置1的元素下沉到合适位置,使堆重新有序
        sink(1);
        return maxValue;
    }

    /**
     * 使用下沉算法,使索引在index位置的元素在堆中出于一个正确的位置
     * @param index 要检查的元素的索引
     */
    public void sink(int index){

        //从此元素开始,向下依次检查子元素,直至叶节点元素的父元素(即确保检查的元素有子元素)
        while ((2*index <= size)){
            int max;    //记录较大节点所在索引
            //如果有右子元素
            if ((2*index+1 <= size)){
                //判断左子元素是否小于右子元素
                if (less(2*index,2*index+1)){
                    //左子元素小于右子元素,最大值为右子元素
                    max = 2*index +1;
                }else {
                    //左子元素大于右子元素,最大值为左子元素
                    max = 2*index;
                }
            //没有右子元素
            }else {
                //最大值为左子元素
                max = 2*index;
            }
            //如果要检查元素索引不小于当前找到的最大值索引(即该元素大于等于其下方父元素)
            if (!less(index,max)){
                //说明该元素已出于正确位置,跳出循环
                break;
            }
            //要检查的元素下还有更大的元素,则交换该元素和找到的最大值元素
            exchange(index,max);
            //将要检查的元素的索引设为交换位置之后的元素,继续进入循环检查
            index = max;
        }
    }
}
