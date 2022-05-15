package graph.undirectedGraph;


import linearList.sequenceStack.SequenceStack;

/**
 * 基于深度优先搜索,查询两点是否连通,以及记录途经的顶点
 */
public class DepthFirstPath {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private static boolean[] vertexMarked;
    //起始顶点索引
    private static int startVertex;
    //存储经过各个顶点的上一个顶点,数组索引为查询的顶点,数组值为上一个顶点
    private static int lastPassVertex[];

    /**
     * 根据起点和终点,判断两点是否连通
     * @param graph 需要搜索的图
     * @param startVertex 起点顶点索引
     * @param endVertex 终点顶点索引
     * @return 如果起点和终点连通,返回含有经过的顶点索引的队列;如果不连通,返回空队列
     */
    public static SequenceStack<Integer> getPath(Graph graph, int startVertex, int endVertex){
        //使用深度优先搜索找出和起点相通的所有顶点,并记录经过的每个顶点的上一个顶点
        search(graph,startVertex);
        //如果终点没有被搜索过,则返回空队列
        if (!isMarked(endVertex)){
            return new SequenceStack<Integer>();
        }
        //创建一个用来记录所有经过的顶点的队列
        SequenceStack<Integer> pathStack = new SequenceStack<>();
        //从终点开始,一次查询经过各个顶点的上一个顶点,直到查询到起点
        for (int pathVertex = endVertex;pathVertex != DepthFirstPath.startVertex; pathVertex = lastPassVertex[pathVertex]){
            //将查询到的所有顶点压入队列
            pathStack.push(pathVertex);
        }
        //返回带有所有经过顶点的队列
        return pathStack;
    }

    /**
     * 使用深度优先搜索找出和起点相通的所有顶点,并记录经过的每个顶点的上一个顶点
     * @param graph 需要搜索的图
     * @param startVertex 起点顶点索引
     */
    private static void search(Graph graph,int startVertex){
        //初始化vertexMarked数组
        vertexMarked = new boolean[graph.getVertexCount()];
        //初始化起点
        DepthFirstPath.startVertex = startVertex;
        //初始化lastPassVertex数组
        lastPassVertex = new int[graph.getVertexCount()];
        //调用depthFirstSearch()方法进行递归搜索
        depthFirstPath(graph,startVertex);
    }

    /**
     * 使用递归的方式,找出和指定顶点vertexIndex相通的所有顶点,并记录经过的每个顶点的上一个顶点
     * @param graph 需要搜索的图
     * @param vertexIndex 起点顶点索引
     */
    private static void depthFirstPath(Graph graph,int vertexIndex){
        //将当前顶点标记为已搜索
        vertexMarked[vertexIndex] = true;
        //通过邻接表获得和当前顶点相通的所有顶点,进行遍历
        for (Integer adjoiningVertex : graph.getAdjoiningVertex(vertexIndex)){
            //如果想通的顶点在之前没有搜索过,则递归继续搜索该顶点
            if (!vertexMarked[adjoiningVertex]){
                //将当前顶点索引作为相通顶点的上一个经过顶点,存入lastPassVertex[]数组
                lastPassVertex[adjoiningVertex] = vertexIndex;
                //递归
                depthFirstPath(graph,adjoiningVertex);
            }
        }

    }

    /**
     * 判断指定顶点是否在之前被搜索过
     * @param vertexIndex 指定顶点索引
     * @return 搜索过返回true,未搜索过返回false
     */
    public static boolean isMarked(int vertexIndex){
        return vertexMarked[vertexIndex];
    }

}
