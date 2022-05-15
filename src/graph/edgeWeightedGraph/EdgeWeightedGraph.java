package graph.edgeWeightedGraph;

import java.util.ArrayList;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    //顶点数目
    private final int vertexCount;
    //边的数目
    private int edgeCount;
    //邻接表:索引号代表顶点,值代表和该顶点相连接的边
    private ArrayList<Edge>[] adjacencyList;

    /**
     * 创建一个含有vertexCount个顶点的加权无向图
     * @param vertexCount 顶点个数
     */
    public EdgeWeightedGraph(int vertexCount){
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
     * 向加权无向图添加一条边
     * @param edge 边对象
     */
    public void addEdge(Edge edge){
        //获取要添加的边的两个顶点
        int vertex1 = edge.getVertex();
        int vertex2 = edge.getAnotherVertex(vertex1);

        //为两个顶点的邻接表中添加这条边
        adjacencyList[vertex1].add(edge);
        adjacencyList[vertex2].add(edge);
        //边数量+1
        edgeCount++;
    }

    /**
     * 获取加权无向图的所有边
     * @return 装有所有边的集合
     */
    public ArrayList<Edge> getAllEdges(){
        //创建一个用来存储所有边的集合
        ArrayList<Edge> edges = new ArrayList<>();
        //从0开始遍历所有顶点
        for (int vertex = 0;vertex < vertexCount;vertex++){
            //获取每个顶点相邻的边
            for (Edge edge : getAdjoiningVertex(vertex)){
                //对于一条边的两个顶点,只有查询到索引值较小的那个顶点时才计入,防止一条边被计算两次
                if (edge.getAnotherVertex(vertex) > vertex){
                    edges.add(edge);
                }
            }
        }
        //返回存有所有边的集合
        return edges;
    }


    /**
     * 根据指定顶点的索引号获取其相邻的边
     * @param vertex 指定顶点的索引号
     * @return 装有其相邻的边的ArrayList集合
     */
    public ArrayList<Edge> getAdjoiningVertex(int vertex){
        return adjacencyList[vertex];
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
