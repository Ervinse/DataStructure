package tree.binarySearchTree;

import linearList.sequenceQueue.SequenceQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 二分查找树测试用例
 */
public class BinarySearchTreeTestCase {

    static BinarySearchTree<Integer, Integer> integerStringBinarySearchTree = new BinarySearchTree<>();

    /**
     * 添加测试数据
     */
    @BeforeEach
    void addData(){
        integerStringBinarySearchTree.put(10,10);
        integerStringBinarySearchTree.put(4,4);
        integerStringBinarySearchTree.put(14,14);
        integerStringBinarySearchTree.put(2,2);
        integerStringBinarySearchTree.put(8,8);
        integerStringBinarySearchTree.put(1,1);
        integerStringBinarySearchTree.put(3,3);
        integerStringBinarySearchTree.put(6,6);
        integerStringBinarySearchTree.put(9,9);
        integerStringBinarySearchTree.put(5,5);
        integerStringBinarySearchTree.put(7,7);

//        for (int i = 100;i > 0;i--){
//            integerStringBinarySearchTree.put(i,i);
//        }
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){

        //删除2-left节点
        integerStringBinarySearchTree.delete(4);
        //测试2-left节点右子树中最小值节点的兄弟节点是否存在
        Integer integer = integerStringBinarySearchTree.get(7);
        assert 7 == integer;

    }

    /**
     * 测试最小值
     */
    @Test
    public void testMin(){
        Integer min = integerStringBinarySearchTree.min();
        assert min == 1;
    }

    /**
     * 测试最大值
     */
    @Test
    public void testMax(){
        Integer max = integerStringBinarySearchTree.max();
        assert max == 14;
    }


    /**
     * 测试前序遍历
     */
    @Test
    public void testPreErgodic(){

        ArrayList<Integer> keys = integerStringBinarySearchTree.preErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试中序遍历
     */
    @Test
    public void testMidErgodic(){

        ArrayList<Integer> keys = integerStringBinarySearchTree.midErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试后序遍历
     */
    @Test
    public void testAfterErgodic(){

        ArrayList<Integer> keys = integerStringBinarySearchTree.afterErgodic();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
    }


    /**
     * 测试层序遍历
     */
    @Test
    public void testLayerErgodic(){

        SequenceQueue<Integer> integerSequenceQueue = integerStringBinarySearchTree.layerErgodic();
        integerSequenceQueue.printValue();
    }


    /**
     * 测试最大深度
     */
    @Test
    public void testMaxDepth(){
        int maxDepth = integerStringBinarySearchTree.maxDepth();
        System.out.println(maxDepth);
    }

}
