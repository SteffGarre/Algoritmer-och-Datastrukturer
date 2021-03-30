package Uppgift1;

//Klassen Graph är baserad på Princetons kod
public class Graph {

    private final int V;             //antal vertices (noder/stater)
    private int E;                  //antal edges (kanter/väg mellan stater)
    private Bag<Integer>[] adj;     //en array med en Bag lista

    //En graph constructor, skapas i storlek V där varje indecx i adj[] får en ny Bag (länkade nodlistor)¢¢
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    //Returnerar antal hörn
    public int V() {
        return V;
    }

    //Returnerar antal kanter
    public int E() {
        return E;
    }

    //Returnerar en önskad bag enligt int V
    public Bag<Integer> bag(int v) {
        return adj[v];
    }


    //Metod lägger till W i V's bag och V i W's bag
    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
       // adj[w].add(v);
    }
    //Metod returnear en Iterable som gör det möjligt att gå igenom länkade noder till adj[] (dess Bag)
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


}