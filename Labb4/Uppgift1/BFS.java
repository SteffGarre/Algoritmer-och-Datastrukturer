package Uppgift1;

//Klassen är baserad på Princeton kod
public class BFS {

    private static final int INFINITY = Integer.MAX_VALUE; // ett "oändlig" tal
    private boolean[] marked;  // marked[v] = finns det en väg mellan S och V
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path


    //Metod skapar ett objekt av BFS mha Graph och en source node S
    //storlek av arrays nedan är enligt antal vertices (noder) i Graph
    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];

        bfs(G, s);
    }

    // breadth-first search från source noden S
    private void bfs(Graph G, int s) {
        //Initiera en ny kö och enqueuer source noden
        Queue<Integer> q = new Queue<>();
        //sätter alla index i distTo[] = INFINITY
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        //while loop körs så länge kön inte är tom. Vi börjar med att dequeuea source noden och kollar vilka
        //"stater" vi kan nå från dess bag. Alla stater i denna bag för distTo = 1. Förvarje ny nivå (bag) så ökar vi
        //distTo [] med + 1. Vi enqueuer och dequeuear tills vi har nått alla "stater" vi kan nå.
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    //Kollar om det finns en väg mellan S och V
    public boolean hasPathTo(int v) {
        return marked[v];
    }


    //metod returnerar en Iterable (path) enligt det som har pushats till Stack, metod jobbar sig från V till S
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        //for loppen körs sä länge distTo[] != 0,  annars har vi nått vår source node
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

}
