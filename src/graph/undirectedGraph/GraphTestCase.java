package graph.undirectedGraph;

import linearList.sequenceStack.SequenceStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 无向图图测试用例
 */
public class GraphTestCase {

    static Graph graph = new Graph(20);

    @BeforeEach
    public void addTestData(){
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,1);
        graph.addEdge(2,4);

        graph.addEdge(11,12);
        graph.addEdge(12,13);
        graph.addEdge(13,14);
        graph.addEdge(14,15);
        graph.addEdge(15,16);
        graph.addEdge(16,12);
        graph.addEdge(13,17);
        graph.addEdge(13,18);
        graph.addEdge(12,19);
    }

    /**
     * 测试深度优先搜索
     */
    @Test
    public void testDepthFirstSearch(){
        int connectedVertexCount = DepthFirstSearch.search(graph, 1);
        System.out.println("连通的顶点个数为:" + connectedVertexCount);
        connectedVertexCount = DepthFirstSearch.search(graph, 11);
        System.out.println("连通的顶点个数为:" + connectedVertexCount);
    }

    /**
     * 测试广度优先搜索
     */
    @Test
    public void testBreadthFirstSearch(){
        int connectedVertexCount = BreadthFirstSearch.search(graph, 1);
        System.out.println("连通的顶点个数为:" + connectedVertexCount);
        connectedVertexCount = BreadthFirstSearch.search(graph, 11);
        System.out.println("连通的顶点个数为:" + connectedVertexCount);
    }


    /**
     * 测试基于深度优先搜索,查询两点是否连通,以及记录途经的顶点
     */
    @Test
    public void testDepthFirstPath(){
        //查询1和11是否连通
        SequenceStack<Integer> path = DepthFirstPath.getPath(graph, 1,11);
        if (path.isEmpty()){
            System.out.println("起点和终点不连通");
        }else {
            path.printValue();
        }

        //查询1和11是否连通
        path = DepthFirstPath.getPath(graph, 11,15);
        if (path.isEmpty()){
            System.out.println("起点和终点不连通");
        }else {
            System.out.println("起点和终点连通");
            System.out.print("经过的顶点为:");
            path.printValue();
        }

    }


}
