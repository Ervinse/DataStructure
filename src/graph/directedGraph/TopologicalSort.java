package graph.directedGraph;

import linearList.sequenceStack.SequenceStack;

/**
 * 拓扑排序
 */
public class TopologicalSort {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private static boolean[] vertexMarked;
    //按顺序存储各个顶点的栈
    private static SequenceStack<Integer> vertexOrderStack;

    /**
     * 基于深度优先搜索,对指定图进行拓扑排序
     * @param digraph 要搜索的图
     * @return 存有按顺序存储各个顶点的栈
     */
    public static SequenceStack<Integer> sort(Digraph digraph){

        //初始化vertexMarked数组
        vertexMarked = new boolean[digraph.getVertexCount()];
        //初始化vertexOrderStack栈
        vertexOrderStack= new SequenceStack<>();

        //如果要搜索的图不存在回环
        if (!DirectedCycle.checkCycle(digraph)){
            //从顶点0开始遍历
            for (int vertex = 0; vertex < digraph.getVertexCount(); vertex++) {
                //如果此顶点之前没有被检查过
                if (!isMarked(vertex)){
                    //调用sort()方法,找出指定顶点vertex相通的所有顶点,依次入栈
                    sort(digraph, vertex);
                }
            }
            //将存有按顺序存储各个顶点的栈返回
            return vertexOrderStack;
        }
        //如果图中存在回环,则返回null
        return null;

    }


    /**
     * 使用递归的方式,基于深度优先搜索,找出指定顶点vertex相通的所有顶点,依次入栈
     * @param digraph 需要搜索的图
     * @param vertex 指定顶点
     */
    private static void sort(Digraph digraph,int vertex){
        //将当前顶点标记为已搜索
        vertexMarked[vertex] = true;

        //遍历指定顶点的下一个顶点
        for (Integer nextVertex : digraph.getAdjoiningVertex(vertex)) {
            //如果下一个顶点没有被搜索过,则将下一个顶点作为指定顶点进行下一轮搜索
            if (!isMarked(nextVertex)) {
                //调用sort()方法进行递归搜索
                sort(digraph, nextVertex);
            }
        }

        //让顶点vertex进栈
        vertexOrderStack.push(vertex);
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
