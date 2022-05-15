package sort;

public class BubbleSort {

    public static void sort(int[] arr){
        boolean isExchange = false;
        // 进行arr.length-1次循环
        // 每一次循环，将当前循环中的最大的数排在末尾
        for (int i = arr.length-1;i > 0;i--){
            //在一次循环中，相邻两个数进行比较
            for (int j = 0;j < i;j++){
                //如果前面大于后面，二者交换
                if (bigger(arr[j], arr[j + 1])) {
                    exchange(arr,j,j+1);
                    //发生交换
                    isExchange = true;
                }
            }
            //如果本次循环没有发生交换，则说明剩下的数据已经有序
            if (!isExchange){
                break;
            }
        }

    }

    static boolean bigger(int a,int b){
        if (a > b){
            return true;
        }else {
            return false;
        }
    }

    static void exchange(int[] arr,int a,int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
