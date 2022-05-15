package sort;

public class InsertionSort {

    public static void sort(int[] arr){
        //将所有元素分成两块，左边为已排序元素集合，右边为未排序集合
        //在第一次循环中，设定第一个数为已排序元素，剩下的为未排序元素
        // 从第二个元素开始遍历，直至最后一个元素
        //从第二次循环开始，每次遍历起始值+1
        for (int i =1;i < arr.length;i++){
            //在已排序元素中，从右向左遍历
            for (int j = i;j > 0;j--){
                //依次将完成排序的元素和未排序中的第一个元素相比较，如果左边数大于右边的数，交换二者的值
                if (bigger(arr[j-1],arr[j])){
                    exchange(arr,j-1,j);
                }else {
                    //左边数小于右边的数，找到该元素，结束本次循环
                    break;
                }
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
