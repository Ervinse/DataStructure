package sort;

public class QuickSort {

    public static void sort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;

        separate(arr,lo,hi);
    }

    private static void separate(int[] arr,int lo,int hi){
        //安全性校验
        if (hi <= lo){
            return;
        }

        //在lo到hi位置的子组中，以lo为标准值，将子组中所有小于标注值放置在标准值左侧，右侧同理，返回标准值位置
        int partition = partition(arr, lo, hi);

        //递归，将左侧到标准值的数值作为一个新子组，重复上述过程
        separate(arr,lo,partition - 1);
        //递归，将标准值到右侧的数值作为一个新子组，重复上述过程
        separate(arr,partition +1,hi);

    }

    //将lo放置到合适到位置，使得在lo到hi段中的数值中，比lo小的放置在lo左侧，比lo大的放置在lo右侧，
    private static int partition(int[] arr,int lo,int hi){
        //将本段第一个值作为标准值
        int key = arr[lo];

        //定义高低两个指针，分别指向第一个数值和最后一个数值
        int left = lo;
        int right = hi + 1;

        while (true){
            //右指针从右向左扫描，直到找到一个比标准值小的元素，停止
            while (less(key,arr[--right])){
                if (right == lo){
                    break;
                }
            }
            //左指针从左向右扫描，直到找到一个比标准值大的元素，停止
            while (less(arr[++left],key)){
                if (left == hi){
                    break;
                }
            }
            /*
                判断左右指针是否重合或者交错
                    如果是，则证明元素扫描完毕，元素已经根据标准值分布两侧
                    如果不知，则说明找到没有处于两侧正确位置的元素，交换位置，左右指针重现扫描
             */
            if (left >= right){
                break;
            }else {
                exchange(arr,left,right);
            }
        }

        //交换标准值和右指针数值
        exchange(arr,lo,right);
        //返回标注值位置
        return right;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exchange(int[] arr,int a,int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
