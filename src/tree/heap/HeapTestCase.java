package tree.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 堆测试用例
 */
public class HeapTestCase {

    static Heap<Integer> integerHeap = new Heap<>(10);

    /**
     * 添加测试数据
     */
    @BeforeEach
    void addTestData(){

        for (int i = 1;i <= 10;i++) {
            integerHeap.insert(i);
        }
    }

    /**
     * 测试删除最大值
     */
    @Test
    public void testDelete(){
        //十个数据,删除最大数十一次
        for (int i = 1; i <= 11; i++) {
            Integer deleteNum = integerHeap.deleteMax();
            System.out.print(deleteNum + " ");
        }

        System.out.println();
        System.out.println("删除测试完成");
    }
}
