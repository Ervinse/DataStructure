package graph.undirectedGraph;

import linearList.sequenceQueue.SequenceQueue;

/**
 * 广度优先搜索
 */
public class BreadthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    static private boolean[] vertexMarked;
    //记录有多少个顶点与s顶点相通
    static private int count;
    //用来存储待搜索邻接表的点
    private static SequenceQueue<Integer> waitSearchQueue;

    /**
     * 使用广度优先搜索找出和指定顶点vertexIndex想通的所有顶点
     * @param graph 需要搜索的图
     * @param vertexIndex 指定顶点索引
     * @return 和指定顶点vertexIndex相通的所有顶点的个数
     */
    public static int search(Graph graph,int vertexIndex){
        //初始化已搜索标记数组
        vertexMarked = new boolean[graph.getVertexCount()];
        //初始化与当前顶点相通的顶点的数量
        count = 0;
        waitSearchQueue= new SequenceQueue<>();
        //调用depthFirstSearch()方法进行递归搜索
        breadthFirstSearch(graph,vertexIndex);

        //由于在进入指定顶点时,顶点个数会+1,故此处需要减去
        return connectedVertexCount();
    }

    /**
     * 使用递归的方式,找出和指定顶点vertexIndex相通的所有顶点
     * @param graph 需要搜索的图
     * @param vertexIndex 指定顶点索引
     */
    public static void breadthFirstSearch(Graph graph,int vertexIndex){
        //将当前顶点标记为已搜索
        vertexMarked[vertexIndex] = true;
        //输出当前顶点的索引
        System.out.print(vertexIndex + " ");
        //让第一个顶点进入待搜索队列
        waitSearchQueue.enQueue(vertexIndex);
        //循环取出待搜索队列中的顶点,指定队列为空
        while (!waitSearchQueue.isEmpty()){
            //弹出一个待搜索队列中的顶点
            int waitSearchVertex = waitSearchQueue.deQueue();
            //遍历与该待搜索顶点相通的所有顶点
            for (int adjoiningVertex : graph.getAdjoiningVertex(waitSearchVertex)){
                //如果与该待搜索顶点相通的顶点没有标记(即为新顶点)
                if (!isMarked(adjoiningVertex)){
                    //标记新顶点
                    vertexMarked[adjoiningVertex] = true;
                    //压入待搜索队列,等待搜索和他相通的顶点
                    waitSearchQueue.enQueue(adjoiningVertex);
                    //将本次搜索到的顶点数计入
                    count++;
                    //打印新顶点
                    System.out.print(adjoiningVertex + " ");
                }
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
