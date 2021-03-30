package Uppgift1;

//Klassen baserad på Princetons kod
public class DFS {

    private boolean[] marked;    // marked[v] = finns det en väg mellan s och v?
    private int[] edgeTo;        // edgeTo[v] = sista kanten i s-v path
    private final int s;         // source node

    //Metod tar en emot ett Graph-objekt samt en source node
    public DFS(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // depth first search från S - source node, markerar index i marked[] med true om det finns en väg
    private void dfs(Graph G, int v) {

        marked[v] = true;

        // for loppen jobbar rekursivt och markerad edgeTo [] så länge marked[w] inte ör sann.
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    //metod gör en snabb kontroll om det finns en väg mellan S och V genom att kolla marked[v]
    public boolean hasPathTo(int v) {

        return marked[v];
    }

    // Returnerar en path enligt det som har pushats till Stack, metod jobbar sig från V till S
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}
