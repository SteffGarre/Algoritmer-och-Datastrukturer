package Uppgift3;

//Klassen är enligt Princeton kod
public class EdgeWeightedGraph {
    private final int V;                //V ger oss antal verticeds i graf klassen
    private int E;                      //E ger oss antal edges i graf klassen
    private BagEdge<Edge>[] adj;        // för varje index i array finns det en bag-lista som håller typen <Edge>


    //En constructor som initierar graf-klassen. Skapas enligt storlek = V och initierar en bag till varje
    //indexplats i adj[].
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (BagEdge<Edge>[]) new BagEdge[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new BagEdge<>();
        }
    }


    //Returnerar antal vertices i graf-klass
    public int V() {
        return V;
    }

    //returnerar antal edges i graf-klass
    public int E() {
        return E;
    }

    //Returnerar en önskad bag enligt int V
    public BagEdge<Edge> bag(int v) {
        return adj[v];
    }


    //metod parar ihop vägar i varje textfilsrad enligt dess edge.
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    //returnerar en Iterable som gör det möjligt att gå igenom noder i varje bag i adj[]
    public Iterable<Edge> adj(int v) {

        return adj[v];
    }


}
