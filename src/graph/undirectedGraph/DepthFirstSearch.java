package graph.undirectedGraph;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    static private boolean[] vertexMarked;
    //记录有多少个顶点与s顶点相通
    static private int count;

    /**
     * 使用深度优先搜索找出和指定顶点vertexIndex相通的所有顶点
     * @param graph 需要搜索的图
     * @param vertexIndex 指定顶点索引
     * @return 和指定顶点vertexIndex相通的所有顶点的个数
     */
    public static int search(Graph graph,int vertexIndex){
        //初始化已搜索标记数组
        vertexMarked = new boolean[graph.getVertexCount()];
        //初始化与当前顶点相通的顶点的数量
        count = 0;
        //调用depthFirstSearch()方法进行递归搜索
        depthFirstSearch(graph,vertexIndex);

        //由于在进入指定顶点时,顶点个数会+1,故此处需要减去
        return connectedVertexCount() -1;
    }


    /**
     * 使用递归的方式,找出和指定顶点vertexIndex相通的所有顶点
     * @param graph 需要搜索的图
     * @param vertexIndex 指定顶点索引
     */
    private static void depthFirstSearch(Graph graph,int vertexIndex){
        //将当前顶点标记为已搜索
        vertexMarked[vertexIndex] = true;
        //输出当前顶点的索引
        System.out.print(vertexIndex + " ");
        //将本次搜索到的顶点数计入
        count++;
        //通过邻接表获得和当前顶点相通的所有顶点,进行遍历
        for (Integer adjoiningVertex : graph.getAdjoiningVertex(vertexIndex)){
            //如果想通的顶点在之前没有搜索过,则递归继续搜索该顶点
            if (!isMarked(adjoiningVertex)){
                depthFirstSearch(graph,adjoiningVertex);
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

    /**
     * 获取和指定顶点相通的顶点个数
     * @return 和指定顶点相通的顶点个数
     */
    public static int connectedVertexCount(){
        return count;
    }
}
