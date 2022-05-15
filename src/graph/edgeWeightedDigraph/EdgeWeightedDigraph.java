package graph.edgeWeightedDigraph;

import graph.edgeWeightedGraph.Edge;

import java.util.ArrayList;

public class EdgeWeightedDigraph {

    //顶点数目
    private final int vertexCount;
    //边的数目
    private int edgeCount;
    //邻接表:索引号代表顶点,值代表和该顶点相连接的边
    private ArrayList<DirectedEdge>[] adjacencyList;


    /**
     * 创建一个含有vertexCount个顶点的加权有向图
     * @param vertexCount 顶点个数
     */
    public EdgeWeightedDigraph(int vertexCount) {

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
     * 向加权有向图添加一条边
     * @param edge 边对象
     */
    public void addEdge(DirectedEdge edge){

        //获取当前边的起点顶点
        int startVertex = edge.getStartVertex();
        //在起点顶点的邻接表中添加这条边
        adjacencyList[startVertex].add(edge);
        //边数量+1
        edgeCount++;
    }

    /**
     * 根据指定顶点的索引号获取其相邻的边
     * @param vertex 指定顶点的索引号
     * @return 装有其相邻的边的ArrayList集合
     */
    public ArrayList<DirectedEdge> getAdjoiningVertex(int vertex){
        return adjacencyList[vertex];
    }


    /**
     * 获取加权有向图的所有边
     * @return 装有所有边的集合
     */
    public ArrayList<DirectedEdge> getAllEdges(){
        //创建一个用来存储所有边的集合
        ArrayList<DirectedEdge> edges = new ArrayList<>();
        //从0开始遍历所有顶点
        for (int vertex = 0;vertex < vertexCount;vertex++){
            //获取每个顶点相邻的边
            for (DirectedEdge edge : getAdjoiningVertex(vertex)){
                    edges.add(edge);

            }
        }
        //返回存有所有边的集合
        return edges;
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
