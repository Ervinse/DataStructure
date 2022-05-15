package graph.edgeWeightedGraph;

/**
 * 无向边
 */
public class Edge implements Comparable<Edge>{

    private final int vertex1;      //顶点1
    private final int vertex2;      //顶点2
    private final double weight;    //当前边权重

    public Edge(int vertex1,int vertex2,double weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int getVertex(){
        return vertex1;
    }

    public int getAnotherVertex(int vertex){
        if (vertex == vertex1){
            return vertex2;
        }else if (vertex == vertex2) {
            return vertex1;
        }
        return -1;
    }

    @Override
    public int compareTo(Edge edge) {
        int compareResult;

        if (this.getWeight() > edge.getWeight()){
            compareResult = 1;
        }else if (this.getWeight() < edge.getWeight()){
            compareResult = 0;
        }else {
            compareResult = 0;
        }
        return compareResult;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}
