package tree.redBlackTree;


import linearList.sequenceQueue.SequenceQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 红黑树测试用例
 */
public class RedBlackTreeTestCase {

    static RedBlackTree<Integer, Integer> integerStringRedBlackTree = new RedBlackTree<>();

    /**
     * 添加测试数据
     */
    @BeforeEach
    void addData() {
        integerStringRedBlackTree.put(10, 10);
        integerStringRedBlackTree.put(4, 4);
        integerStringRedBlackTree.put(14, 14);
        integerStringRedBlackTree.put(2, 2);
        integerStringRedBlackTree.put(8, 8);
        integerStringRedBlackTree.put(1, 1);
        integerStringRedBlackTree.put(3, 3);
        integerStringRedBlackTree.put(6, 6);
        integerStringRedBlackTree.put(9, 9);
        integerStringRedBlackTree.put(5, 5);
        integerStringRedBlackTree.put(7, 7);


//        for (int i = 100;i > 0;i--){
//            integerStringRedBlackTree.put(i,i);
//        }
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){

        //删除2-left节点
        integerStringRedBlackTree.delete(4);
        //测试2-left节点右子树中最小值节点的兄弟节点是否存在
        Integer integer = integerStringRedBlackTree.get(7);
        assert 7 == integer;

    }


    /**
     * 测试最小值
     */
    @Test
    public void testMin(){
        Integer min = integerStringRedBlackTree.min();
        assert min == 1;
    }

    /**
     * 测试最大值
     */
    @Test
    public void testMax(){
        Integer max = integerStringRedBlackTree.max();
        assert max == 14;
    }


    /**
     * 测试前序遍历
     */
    @Test
    public void testPreErgodic(){

        ArrayList<Integer> keys = integerStringRedBlackTree.preErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试中序遍历
     */
    @Test
    public void testMidErgodic(){

        ArrayList<Integer> keys = integerStringRedBlackTree.midErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试后序遍历
     */
    @Test
    public void testAfterErgodic(){

        ArrayList<Integer> keys = integerStringRedBlackTree.afterErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试层序遍历
     */
    @Test
    public void testLayerErgodic(){

        SequenceQueue<Integer> integerSequenceQueue = integerStringRedBlackTree.layerErgodic();
        integerSequenceQueue.printValue();
    }


    /**
     * 测试最大深度
     */
    @Test
    public void testMaxDepth(){
        int maxDepth = integerStringRedBlackTree.maxDepth();
        System.out.println(maxDepth);
    }


}
