package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] arr){

        //根据数组长度，确定增量的初始值
        int h = 1;
        while (h < arr.length/2){
            h = h * 2 + 1;
        }
        //根据每次增量进行排序，直到增量为1
        while (h >= 1){
            //从第h个数开始，每个数和其左边同组数依次比较，直到末尾  （该循环控制谁在比较）
            for (int i =h;i < arr.length;i++){
                //进行插入排序
                //每个数依次和他同组中左边第其他数（即i-h，i-2h...）比较  （该循环控制和谁比较））
                for (int j = i;j >= h;j -= h){
                    //如果左边数大于右边数，交换数值
                    if (bigger(arr[j - h],arr[j] )){
                        exchange(arr,j - h,j);
                    }else {
                        //左边数小于右边的数，找到该元素，结束本次循环
                        break;
                    }
                }
            }
            //完成一次增量的比较，减小增量，直到增量为1
            h  =  h / 2;
        }
    }

    static boolean bigger(int a,int b){
        return a > b;
    }

    static void exchange(int[] arr,int a,int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
