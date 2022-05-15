package sort;

public class SelectionSort {

    public static void sort(int[] arr){
        for (int i = 0;i < arr.length - 1;i++){
            //将本次循环的最小值索引设置为选择的第一个数
            int minIndex = i;
            //从本次循环第二个数开始，比较最小值和当前索引值的大小
            for (int j = i+1;j < arr.length;j++){
                //如果最小值大小 大于当前索引数大小，则将当前索引数的索引值设置为最小值索引值
                if (bigger(arr[minIndex],arr[j] )){
                    minIndex = j;
                }
            }

            //交换本次循环中的第一个数和最小值索引的数的大小
            exchange(arr,i,minIndex);
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
