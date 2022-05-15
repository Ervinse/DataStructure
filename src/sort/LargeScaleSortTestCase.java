package sort;

import java.io.*;

/**
 * 大规模数据排序测试用例
 * 本测试用例提供int[]和Integer[]两种内含十万个元素的初始无序数组
 */
public class LargeScaleSortTestCase {

    public static void main(String[] args) throws IOException {
        //原始无序数组
        int[] array = getArray();
        Integer[] integerArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            integerArray[i] = array[i];
        }

        long startTime = System.currentTimeMillis();
        //开始测试

        HeapSort.sort(integerArray);
//        QuickSort.sort(array);

        long endTime = System.currentTimeMillis();
        for (int i : integerArray) {
            System.out.println(i);
        }

        //结束测试
        System.out.println("运行时间为" + (endTime - startTime) + "毫秒");
    }

    /**
     * 从硬盘中读取测试数据,封装到int数组中
     * @return 装有十万个无序元素的int数组
     * @throws IOException 文件读取异常
     */
    private static int[] getArray() throws IOException {
        int[] arr = new int[100000];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/sort/num/numRandom.txt")));
        String line = null;
        int i = -1;
        while ((line = bufferedReader.readLine()) != null){
            i++;
            int num = Integer.parseInt(line);
            arr[i] = num;
        }

        return arr;
    }

}
