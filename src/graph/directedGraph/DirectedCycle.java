package graph.directedGraph;

/**
 * 检测有向图中是否存在回环工具类
 */
public class DirectedCycle {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private static boolean[] vertexMarked;
    //记录图中是否有环
    private static boolean hasCycle;
    //索引代表顶点，值表示当前顶点是否在本次循环中已经被搜索
    private static boolean[] vertexMarkedInThisCycle;


    /**
     * 检查此图中是否存在回环
     * @param digraph 需要搜索的图
     * @return 如果存在回环,返回true;如果不存在回环,返回false
     */
    public static boolean checkCycle(Digraph digraph){
        //初始化vertexMarked数组
        vertexMarked = new boolean[digraph.getVertexCount()];
        //初始化vertexMarkedInThisCycle数组
        vertexMarkedInThisCycle = new boolean[digraph.getVertexCount()];
        //初始化hasCycle
        hasCycle = false;

        //从顶点0开始遍历
        for (int checkedVertex = 0; checkedVertex < digraph.getVertexCount(); checkedVertex++) {
            //如果此顶点之前没有被检查过
            if (!isMarked(checkedVertex)){
                //检查此顶点和其相通的顶点中是否存在回环
                checkCycleByVertex(digraph, checkedVertex);
            }
        }

        //返回此图是否存在回环
        return hasCycle;
    }

    /**
     * 使用递归的方式,找出和指定顶点vertex相通的所有顶点
     * 并检查这些顶点中是否存在回环
     * @param digraph 需要搜索的图
     * @param vertex 起点顶点索引
     */
    private static void checkCycleByVertex(Digraph digraph,int vertex){
        //将当前顶点标记为已搜索
        vertexMarked[vertex] = true;
        //将当前顶点标记为在本次搜索中已搜索
        vertexMarkedInThisCycle[vertex] = true;

        //遍历指定顶点的下一个顶点
        for (Integer nextVertex : digraph.getAdjoiningVertex(vertex)){
            //如果下一个顶点没有被搜索过,则将下一个顶点作为指定顶点进行下一轮搜索
            if (!isMarked(nextVertex)){
                //调用checkCycleByVertex()方法进行递归搜索
                checkCycleByVertex(digraph, nextVertex);
            }

            //如果所有可以到达的顶点都标记了,开始依次检查当前顶点的下一个顶点是否是之前标记过的顶点
            if (isMarkedInThisCycle(nextVertex)){
                //如果是,则说明有循环
                hasCycle = true;
                //结束方法
                return;
            }
        }

        //如果完成遍历且没有在本次循环中重复进入顶点,说明以当前顶点可以到达的所有顶点组成的路径中没有循环
        //恢复本次循环中标记的顶点
        vertexMarkedInThisCycle[vertex] = false;

        /*
            恢复vertexMarkedInThisCycle[vertex]数组的意义在于:
                vertexMarkedInThisCycle数组标记的是以一个初始顶点为切入,能够到达的所有顶点
                如果这些顶点中不存在环,那么下一步将要检查的是,以一个新的初始顶点为切入(新初始顶点的选取范围是除去这些环以外的顶点),能够到达的所有顶点中是否有循环
                如果不恢复vertexMarkedInThisCycle数组,那么有可能存在同时能被两个初始顶点到达的顶点被检测两次,误判为存在环

                如下图:
                1 --> 2 --> 3
                      ^
                      |
                      4

                当1为初始顶点,检测顶点1 > 2 > 3,标记vertexMarkedInThisCycle[1,2,3] = true,未检出到环,结束递归
                如果不恢复标记,当4为初始顶点,检测到2时,由于之前vertexMarkedInThisCycle[2] = true,则检测到环,与实际不符
                故需在未检测到环,准备结束递归时,要恢复标记vertexMarkedInThisCycle[vertex] = false
         */
    }

    /**
     * 判断指定顶点是否在之前被搜索过
     * @param vertexIndex 指定顶点索引
     * @return 搜索过返回true,未搜索过返回false
     */
    private static boolean isMarked(int vertexIndex){
        return vertexMarked[vertexIndex];
    }

    /**
     * 判断指定顶点是否在本次循环中被搜索过
     * @param vertexIndex 指定顶点索引
     * @return 搜索过返回true,未搜索过返回false
     */
    private static boolean isMarkedInThisCycle(int vertexIndex){
        return vertexMarkedInThisCycle[vertexIndex];
    }


}
