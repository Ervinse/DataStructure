package graph.directedGraph;

import linearList.sequenceStack.SequenceStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 有向图测试用例
 */
public class DigraphTestCase {

    //测试数据1:有环的有向图
    static Digraph digraphHasCycle = new Digraph(10);
    //测试数据2:无环的有向图
    static Digraph digraph = new Digraph(7);

    @BeforeEach
    public void addTestData(){
        //为有环的有向图添加数据
        //添加"Y"字型交叉
        digraphHasCycle.addEdge(0,1);
        digraphHasCycle.addEdge(1,2);
        digraphHasCycle.addEdge(3,2);
        //添加回环
        digraphHasCycle.addEdge(5,6);
        digraphHasCycle.addEdge(6,7);
        digraphHasCycle.addEdge(7,5);


        //为无环的有向图添加数据
        digraph.addEdge(0,1);
        digraph.addEdge(0,2);
        digraph.addEdge(3,2);

        digraph.addEdge(1,4);
        digraph.addEdge(2,5);

        digraph.addEdge(4,6);
        digraph.addEdge(5,6);
    }

    /**
     * 测试 检测有向图中是否存在回环工具类
     */
    @Test
    public void testHasCycle(){
        boolean hasCycle = DirectedCycle.checkCycle(digraphHasCycle);
        assert hasCycle;
//        System.out.println(hasCycle);
    }

    /**
     * 测试 拓扑排序含有回环的有向图
     */
    @Test
    public void testTopologicalSortHasCycle(){
        SequenceStack<Integer> sortStack = TopologicalSort.sort(digraphHasCycle);
        assert sortStack == null;
    }

    /**
     * 测试 拓扑排序
     */
    @Test
    public void testTopologicalSort(){
        SequenceStack<Integer> sort = TopologicalSort.sort(digraph);
        sort.printValue();    //3 0 2 5 1 4 6

    }
}
