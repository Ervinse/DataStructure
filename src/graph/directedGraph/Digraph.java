package graph.directedGraph;

import java.util.ArrayList;

/**
 * 有向图
 */
public class Digraph {

    //顶点数目
    private final int vertexCount;
    //边的数目
    private int edgeCount;
    //邻接表
    private ArrayList<Integer>[] adjacencyList;

    /**
     * 创建一个含有vertexCount个顶点的无向图
     * @param vertexCount 顶点个数
     */
    public Digraph(int vertexCount) {
        //初始化顶点数量
        this.vertexCount = vertexCount;
        //初始化边的数量
        this.edgeCount = 0;
        //初始化邻接表
        this.adjacencyList = new ArrayList[vertexCount];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }


    /**
     * 获取当前有向图的反转图
     * @return 当前有向图的反转图
     */
    private Digraph getReverseGraph(){
        //创建反转图
        Digraph reverseDigraph = new Digraph(vertexCount);
        //遍历所有顶点
        for (int vertex = 0;vertex < vertexCount;vertex++){
            //将每一个顶点指向的下一个顶点取出
            for (Integer nextVertex : adjacencyList[vertex]){
                //反转两个顶点的顺序,添加到反转图
                reverseDigraph.addEdge(nextVertex,vertex);
            }
        }
        //返回反转图
        return reverseDigraph;
    }


    /**
     * 根据指定顶点的索引号获取其相邻的索引顶点
     * @param edge 指定顶点的索引号
     * @return 装有其相邻的索引顶点索引的ArrayList集合
     */
    public ArrayList<Integer> getAdjoiningVertex(int edge){
        return adjacencyList[edge];
    }


    /**
     * 向图中添加一条从顶点e1指向e2的边
     * @param v1 第一个顶点
     * @param v2 第二个顶点
     */
    public void addEdge(int v1,int v2){
        if (!adjacencyList[v1].contains(v2)) {

            adjacencyList[v1].add(v2);
            edgeCount++;
        }
    }


    /**
     * 获取顶点数量
     * @return 顶点数量
     */
    public int getVertexCount(){
        return vertexCount;
    }

    /**
     * 获取边的数量
     * @return 边的数量
     */
    public int getEdgeCount(){
        return edgeCount;
    }
}
