package graph.edgeWeightedDigraph;

/**
 * 有向边
 */
public class DirectedEdge {

    private final int startVertex;      //起始顶点
    private final int endVertex;      //结束顶点
    private final double weight;    //当前边权重


    public DirectedEdge(int startVertex, int endVertex, double weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public double getWeight() {
        return weight;
    }
}
