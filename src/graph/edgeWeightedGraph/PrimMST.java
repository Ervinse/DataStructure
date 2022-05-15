package graph.edgeWeightedGraph;

import linearList.priorityQueue.IndexMinPriorityQueue;
import linearList.sequenceQueue.SequenceQueue;


/**
 * 获取指定的加权无向图的最小生成树
 */
public class PrimMST {

    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private static Edge[] minEdge;
    //索引代表顶点,值表示当前顶点和最小生成树之间的最短边的权重
    private static double[] minEdgeWeight;
    //索引代表顶点，值表示当前顶点是否已在生成树中
    private static boolean[] vertexMarked;
    //存放树中顶点与非树中顶点之间的有效横切边
    private static IndexMinPriorityQueue<Double> sectionWeightQueue;


    /**
     * 获取指定的加权无向图的最小生成树
     * @param graph 指定的图
     * @return 装有最小生成树所有边的队列
     */
    public static SequenceQueue<Edge> getMinimumSpanningTree(EdgeWeightedGraph graph){
        //初始化minEdge
        minEdge = new Edge[graph.getVertexCount()];
        //初始化minEdgeWeight
        minEdgeWeight = new double[graph.getVertexCount()];
        //为每个顶点和最小生成树之间的最短边的权重设置为最大值
        for (int i = 0;i < minEdgeWeight.length;i++){
            minEdgeWeight[i] = Double.POSITIVE_INFINITY;
        }
        //TODO
        //可替换:Arrays.fill(minEdgeWeight, Double.POSITIVE_INFINITY);

        //初始化vertexMarked
        vertexMarked = new boolean[graph.getVertexCount()];
        //初始化sectionWeightQueue
        sectionWeightQueue = new IndexMinPriorityQueue<>(graph.getVertexCount());

        //先将顶点0进入最小生成树中,由于此时树种只有一个顶点0,因此顶点0默认没有与其他顶点相连,所以此时对应权重为0.0
        minEdgeWeight[0] = 0.0;
        sectionWeightQueue.insert(0, 0.0);

        //遍历索引最小优先队列,拿到
        while (!sectionWeightQueue.isEmpty()){
            addVertex(graph, sectionWeightQueue.delMin());
        }

        return getAllEdges();
    }


    /**
     * 将指定顶点vertex添加到最小生成树中,并更新数据
     * @param graph 要搜索的图
     * @param vertex 指定顶点
     */
    private static void addVertex(EdgeWeightedGraph graph,int vertex){
        //把顶点vertex添加到最小生成树中
        vertexMarked[vertex] = true;

        //遍历指定顶点所有相邻的边
        for (Edge edge : graph.getAdjoiningVertex(vertex)){
            //获取该边的另一个顶点
            int anotherVertex = edge.getAnotherVertex(vertex);
            //判断另一个边是否在最小生成树中
            if (vertexMarked[anotherVertex]){
                //如果在树中,跳过此边
                continue;
            }

            //另一边也不在树中,则判断此边此边的权重是否小于anotherVertex顶点到树中已经存在的最小边的权重
            if (edge.getWeight() < minEdgeWeight[anotherVertex]){

                //如果anotherVertex权重更小,则将其顶点索引和该边的权重值添加到记录中
                minEdge[anotherVertex] = edge;
                minEdgeWeight[anotherVertex] = edge.getWeight();
                //更新队列中的索引
                //如果已经存入,则替换
                if (sectionWeightQueue.contains(anotherVertex)){
                    sectionWeightQueue.changeItem(anotherVertex,edge.getWeight());
                }else {
                    //否则插入此记录
                    sectionWeightQueue.insert(anotherVertex,edge.getWeight());
                }
            }
        }
    }


    /**
     * 获取最小生成树的所有边
     * @return 装有最小生成树所有边的队列
     */
    public static SequenceQueue<Edge> getAllEdges(){
        //创建存储最小生成树所有边的队列
        SequenceQueue<Edge> edges = new SequenceQueue<>();
        //遍历minEdge数组,拿到每条边,如果不为null,则添加到队列中
        for (int i = 0; i < minEdge.length; i++) {
            if (minEdge[i] != null){
                edges.enQueue(minEdge[i]);
            }
        }
        //返回
        return edges;
    }

}
