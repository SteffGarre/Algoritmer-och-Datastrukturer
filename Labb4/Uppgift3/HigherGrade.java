package Uppgift3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HigherGrade {

    public static void main (String[] args) throws FileNotFoundException {

        //Läser av "NYC"
        File NYC = new File("/Users/stefangarrido/Desktop/Java/GraphsLabb/src/Uppgift1/test.txt");
        Scanner text = new Scanner(NYC);

        //en graf av typ EdgeWeighted skapas i storlek av antal vertices i NYC textfil.
        EdgeWeightedGraph graph = new EdgeWeightedGraph(264346);
        int start;
        int stop;
        int weight;

        System.out.println("Number of vertices: " + text.nextInt() + ", and number of edges: " + text.nextInt());

        //avläsning av textfil görs så länge the finns en NextLine
        while (text.hasNextLine()) {

            //Varje rad består av 3 st heltal, där dom två första representerar vägar som är kopplade och
            //det sista dess weight, dvs den totala tiden mellan dessa vägar
            start = text.nextInt();
            stop = text.nextInt();
            weight = text.nextInt();

            //för varje rad skapas ett Edge-objekt som läggs till i graph
            Edge edge = new Edge (start,stop,weight);
            graph.addEdge(edge);

        }

        /*
        //Test som printar ut hela adj[] och dess tillhörande bag
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(graph.V() + " vertices, " + graph.E() + " edges " + NEWLINE);
        for (int v = 0; v < graph.V(); v++) {
            sb.append(v + ": ");
            for (Edge w : graph.bag(v)) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        System.out.println(sb.toString()); */



        //Vi ger användare möjligheten att knappa in tre vägar enligt: Gå från A till B, via C.
        Scanner in = new Scanner(System.in);
        System.out.println("Find the shortest path from: ");
        int a = in.nextInt();
        System.out.println("To: ");
        int b = in.nextInt();
        System.out.println("Passing through: ");
        int c = in.nextInt();

        //Vög hittas enligt Dijkstra's shortest path
        DijkstraUndirectedSP sp = new DijkstraUndirectedSP(graph,a);
        int x = 0;
        int totEdge = 0;

        //Upplägget nedan är enligt: Om en väg från A till C finns -printa ut vägem.
        //Kolla därefter en väg från C till B - om det finns printa ut vägen.
        if (sp.hasPathTo(c)) {
            System.out.println("Path between " + a + " and " + c +" :");
            for (Edge e : sp.pathTo(c)) {
                System.out.println(e + " ");
                totEdge += (int) e.weight();
            }
            System.out.println();
            x = 1;
        }
        else {
            System.out.println("No path between " + a + " and " + c +".");
        }



        if(x==1) {

            System.out.println("Path between " + c + " and " + b +" :");
            DijkstraUndirectedSP sp2 = new DijkstraUndirectedSP(graph, c);

            if (sp2.hasPathTo(b)) {
                for (Edge e : sp2.pathTo(b)) {
                    System.out.println(e + " ");
                    totEdge += (int) e.weight();
                }
                System.out.println();

            }
            else {
                System.out.println("No path between " + c + " and " + b + ".");
            }

        }

        System.out.println("Total edge weight: "+ totEdge);
    }
}
