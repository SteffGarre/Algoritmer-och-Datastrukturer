package Uppgift1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) throws FileNotFoundException {


        //Läser av "thedatabase"
        File database = new File("/Users/stefangarrido/Desktop/Java/GraphsLabb/src/Uppgift1/thedatabase.txt");
        Scanner text1 = new Scanner(database);
        Scanner text2 = new Scanner(database);

       BinarySearchST<String, Integer> st = new BinarySearchST<>(50);

        int index = 0;
        String key;

        //while loop körs tills vi har läst av hela "thedatabase", om ett unikt ord uppstår - lagras den i
        //symbol tabellen och ges en "index" (en representation av ett heltal mellan 0-48),
        // indexnr delas ut så fort en ny unik stat läses in
        while (text1.hasNextLine()) {

            key = text1.next();

            //Om det är första ggn ordet uppstår, ge ordet ett index representation
            if (!st.contains(key)) {
                st.put(key, index);
                index++;
            }
        }



        //Nytt graf-objekt skapas i storlek av antal index.
        Graph Graph = new Graph(index);
        String state1;
        String state2;

        //While loopen går igenom "thedatabase" och varje par (stater) i "thedatabese" kopplas ihop i grap-objektet.
        while (text2.hasNextLine()) {

            state1 = text2.next();
            state2 = text2.next();

            Graph.addEdge(st.get(state1), st.get(state2));
        }
        // När vi är klara med graph-objektet har vi array med index 0-48 (som representerar 48 stater) där
        //varje stat har en bag (med heltal) med stater dom kan nå.

        /*
        //Test som printar ut hela adj[] och dess korresponderande bag
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(Graph.V() + " vertices, " + Graph.E() + " edges " + NEWLINE);
        for (int v = 0; v < Graph.V(); v++) {
            sb.append(v + ": ");
            for (int w : Graph.bag(v)) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        System.out.println(sb.toString());  */



        //Låter användaren välja mellan två stater, och därefter hämtar vi dom sökta statens heltalsrepresentation.
        System.out.println("Choose a state: ");
        Scanner in = new Scanner(System.in);
        String word1 = in.nextLine();
        int s = st.get(word1);
        System.out.println("Choose a second state: ");
        String word2 = in.nextLine();
        int v = st.get(word2);

        //Nytt objekt BFS (Breadth First Search) som låter oss hitta den kortaste vägen mellan två sökta stater.
        BFS bfs = new BFS(Graph, s);

        //Iterator används för att söka igenom symboltabellen.
        Iterator<String> itr = st.iterator();
        //Vi sätter string till den första key i Keys i klassen BinarySearchST
        String string = st.min();

        //Om det finns en väg mellan sökta stater printa ut dess representation.
        if (bfs.hasPathTo(v)) {

            System.out.println("Path between State " + word1 + " and State " + word2);

            //pathTo jobbar sig från V till S och pushar till Stack enligt edgeTo []
            for (int x : bfs.pathTo(v)) {

                if (x == s) {
                    System.out.print(word1);
                }
                else {

                    //While loopen itererar igenom keys i Binary Search ST tills den hittar rätt stat
                    //och nollställs därefter.
                    while (true) {

                        if (st.get(string) == x) {
                            System.out.print("-" + string);

                            break;
                        }
                        string = itr.next();
                    }
                    string = st.min();
                    itr = st.iterator();
                }
            }
            System.out.println();
        }
        else
            System.out.println("States not connected: " + word1 + " and " + word2);
    }
}


