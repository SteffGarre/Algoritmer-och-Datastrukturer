package Uppgift3;

public class DijkstraUndirectedSP {

    private double[] distTo;          // distTo[v] = avstånd för den kortaste vägen mellan S och V
    private Edge[] edgeTo;            // edgeTo[v] = senaste edge i den kortaste vägen
    private IndexMinPQ<Double> pq;    // priority queue av vertices


    public DijkstraUndirectedSP(EdgeWeightedGraph G, int s) {

        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];

        //Sätter alla index i distTo till oändlig - detta representerar att vi inte
        // vet hur långt det är för varje nod(index), när vi är klara sätts source till avstånd 0.0.
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // relax vertices i ordning från vår startpunkt S.
        pq = new IndexMinPQ<>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : G.adj(v))
                relax(e, v);
        }

    }

    // relax edge e och uppdatera pq om den ändras
    private void relax(Edge e, int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
    }


    //kollar distTo för att se om det finns en väg till V. Om indexplats innehåller infinity, så kan den inte nås.
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }


    //Iterable användes sig av en Stack för att pusha vägen från V till startpunkt S.
    public Iterable<Edge> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        StackEdge<Edge> path = new StackEdge<>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }




}
