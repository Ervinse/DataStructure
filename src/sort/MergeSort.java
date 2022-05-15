package sort;

public class MergeSort {

    private static int[] assist;

    public static void sort(int[] arr) {
        //辅助数组
        assist = new int[arr.length];

        //定义高位指针和低位指针
        int lo = 0;
        int hi = arr.length - 1;
        separate(arr, lo, hi);
    }

    /**
     * 根据中位指针，将数组分为两部分
     * 使用递归，继续分割，直至无法分割
     * 每一次分割都带有当前长度段的高低指针
     */
    private static void separate(int[] arr, int lo, int hi) {
        //做安全性检校验
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        //递归，继续将左半边分为两部分
        separate(arr, lo, mid);
        //递归，继续将右半边分为两部分
        separate(arr, mid + 1, hi);

        //将本长度段中的左右两段合并为一段
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //从左向右遍历，在两段都没有遍历完成时，判断两个指针都值，数值小都进入辅助数组，直至其中一段完成遍历
        while (p1 <= mid && p2 <= hi) {
            if (less(arr[p1], arr[p2])) {
                assist[i++] = arr[p1++];
            } else {
                assist[i++] = arr[p2++];
            }
        }

        //其中一段完成遍历后，剩下一段顺序进入辅助数组
        //注意：以下两个循环只会进入一个
        while (p1 <= mid) {
            assist[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            assist[i++] = arr[p2++];
        }

        //将辅助数组中都数值复制回原始数组中
        for (int index = lo; index <= hi; index++) {
            arr[index] = assist[index];
        }

    }

    private static boolean less(int a, int b) {
        return a < b;
    }
}
