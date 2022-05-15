package sort;

import java.awt.*;

public class HeapSort <T>{


    public static void sort(Comparable[] source){
        Comparable[] heap = creatHeap(source);
        //定义一个变量,记录未排序的元素中最大的索引
        int size = heap.length - 1;
        //从索引最后的元素开始,不断和第一个元素交换位置
        while (size != 1){
            //交换索引1处的元素和最大索引处的元素
            exchange(heap,1,size);
            //排序交换后,索引size处元素为最大元素,未排序元素数需-1
            size--;
            //对换上来的索引1处元素进行下沉调整,索引在size之后的元素已经从小到大有序,无需参与下沉
            sink(heap,1,size);
        }

        //将heap中的数据拷贝到原数组中
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * 根据源数组,创建一个堆
     * @param source 源数组
     * @return 堆
     */
    private static Comparable[] creatHeap(Comparable[] source){
        //创建堆数组
        Comparable[] heap = new Comparable[source.length + 1];
        //拷贝元素至堆,heap为乱序堆
        System.arraycopy(source, 0, heap, 1, source.length);
        //从长度的二分之一位置向上,依次检查元素,并使用下沉算法使其出于正确位置
        for (int i = heap.length/2; i > 0; i--) {
            sink(heap,i,heap.length - 1);
        }
        //返回有序堆
        return heap;
    }


    /**
     * 使用下沉算法,检查索引在index位置的元素及其子元素,使其在堆中出于一个正确的位置
     * 检查范围:索引地址 index 至 range,超出range索引的数据不予关注
     * @param heap 堆地址
     * @param index 要检查的元素索引
     * @param range 检查范围
     */
    private static void sink(Comparable[] heap,int index,int range){

        //从此元素开始,向下依次检查子元素,直到该元素子元素索引为range
        while (2*index <= range){
            int max;    //记录较大节点所在索引
            //如果有右子元素
            if (2*index+1 <= range){
                //判断左子元素是否小于右子元素
                if (less(heap,2*index,2*index+1)){
                    //左子元素小于右子元素,最大值为右子元素
                    max = 2*index+1;
                }else {
                    //左子元素大于右子元素,最大值为左子元素
                    max = 2*index;
                }
            //没有右子元素
            }else {
                //最大值为左子元素
                max = 2 * index;
            }
            //如果要检查元素索引不小于当前找到的最大值索引(即该元素大于等于其下方父元素)
            if (!less(heap,index,max)){
                //说明该元素已出于正确位置,跳出循环
                break;
            }
            //要检查的元素下还有更大的元素,则交换该元素和找到的最大值元素
            exchange(heap,index,max);
            //将要检查的元素的索引设为交换位置之后的元素,继续进入循环检查
            index = max;
        }
    }


    /**
     * 判断堆中元素i是否小于j
     * @param heap 堆地址
     * @param i 判断的第一个元素
     * @param j 判断的第二个元素
     * @return 小于返回true,大于返回false
     */
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j]) < 0;
    }


    /**
     * 交换堆中元素i和j
     * @param heap 堆地址
     * @param i 交换的第一个元素
     * @param j 交换的第二个元素
     */
    private static void exchange(Comparable[] heap,int i,int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


}
