package graph.edgeWeightedGraph;

import linearList.sequenceQueue.SequenceQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EdgeWeightedGraphTestCase {

    static EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(10);
    static EdgeWeightedGraph primEdgeWeightedGraph = new EdgeWeightedGraph(8);

    @BeforeAll
    public static void addTestData(){

        //初始化edgeWeightedGraph
        Edge edge1 = new Edge(0, 1, 10);
        Edge edge2 = new Edge(1, 2, 10);
        Edge edge3 = new Edge(2, 3, 10);
        Edge edge4 = new Edge(3, 4, 10);
        Edge edge5 = new Edge(4, 5, 10);
        Edge edge6 = new Edge(5, 6, 10);
        Edge edge7 = new Edge(6, 7, 10);

        edgeWeightedGraph.addEdge(edge1);
        edgeWeightedGraph.addEdge(edge2);
        edgeWeightedGraph.addEdge(edge3);
        edgeWeightedGraph.addEdge(edge4);
        edgeWeightedGraph.addEdge(edge5);
        edgeWeightedGraph.addEdge(edge6);
        edgeWeightedGraph.addEdge(edge7);

        //初始化PrimEdgeWeightedGraph
        edge1 = new Edge(4, 5, 0.35);
        edge2 = new Edge(4, 7, 0.37);
        edge3 = new Edge(5, 7, 0.28);
        edge4 = new Edge(0, 7, 0.16);
        edge5 = new Edge(1, 5, 0.32);
        edge6 = new Edge(0, 4, 0.38);
        edge7 = new Edge(2, 3, 0.17);
        Edge edge8 = new Edge(1, 7, 0.19);
        Edge edge9 = new Edge(0, 2, 0.26);
        Edge edge10 = new Edge(1, 2, 0.36);
        Edge edge11 = new Edge(1, 3, 0.29);
        Edge edge12 = new Edge(2, 7, 0.34);
        Edge edge13 = new Edge(6, 2, 0.40);
        Edge edge14 = new Edge(3, 6, 0.52);
        Edge edge15 = new Edge(6, 0, 0.58);
        Edge edge16 = new Edge(6, 4, 0.93);

        primEdgeWeightedGraph.addEdge(edge1);
        primEdgeWeightedGraph.addEdge(edge2);
        primEdgeWeightedGraph.addEdge(edge3);
        primEdgeWeightedGraph.addEdge(edge4);
        primEdgeWeightedGraph.addEdge(edge5);
        primEdgeWeightedGraph.addEdge(edge6);
        primEdgeWeightedGraph.addEdge(edge7);
        primEdgeWeightedGraph.addEdge(edge8);
        primEdgeWeightedGraph.addEdge(edge9);
        primEdgeWeightedGraph.addEdge(edge10);
        primEdgeWeightedGraph.addEdge(edge11);
        primEdgeWeightedGraph.addEdge(edge12);
        primEdgeWeightedGraph.addEdge(edge13);
        primEdgeWeightedGraph.addEdge(edge14);
        primEdgeWeightedGraph.addEdge(edge15);
        primEdgeWeightedGraph.addEdge(edge16);

    }

    @Test
    public void testEdgeWeightedGraph(){
        for (Edge edge : edgeWeightedGraph.getAllEdges()) {
            System.out.println(edge);
        }
    }

    @Test
    public void testPrimMST(){
        SequenceQueue<Edge> minimumSpanningTree = PrimMST.getMinimumSpanningTree(primEdgeWeightedGraph);
        System.out.println("最小生成树为:");
        while (!minimumSpanningTree.isEmpty()){
            Edge edge = minimumSpanningTree.deQueue();
            System.out.print(edge.getVertex() + "-");
            System.out.print(edge.getAnotherVertex(edge.getVertex()) + ":");
            System.out.println(edge.getWeight());
        }
    }
}
