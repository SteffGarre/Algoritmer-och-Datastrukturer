package Uppgift3;

import java.util.ListIterator;

//klass baserad på Princeton kod, klass hanterar generiska objekt.
public class Queue <Item>{

    private Node first;
    private Node last;
    private int N;      // Antal element i nod-listan

    private class Node {    // inbyggd class för att definera noder enligt Princeton kod.
        private Item item;
        private Node  next;
        private Node  prev;
    }

    //enligt Princeton kod
    public boolean isEmpty() {

        return first == null;
    }

    //egen kod, metod lägger till en nod längst bak i kön
    public void enqueue(Item item) {

        //om nod-listan är tom, skapa en ny nod som pekar på sig själv
        if(isEmpty()){
            first = new Node ();             //skapar en ny nod med referens first.
            first.item = item;              //lägg element (tecken som skickas in i metod) i nod.
            first.next = first;             //noden first referens "next" pekar mot first, dvs sig själv.
            first.prev = first;             //noden first referens "prev" pekar mot first, dvs sig själv.
            last = first;                   //referens last pekar mot referens first, dvs första noden.
            N++;                            //öka antal element i lista med 1.
        }
        /*när ovan är klar har vi skapat en första nod där referens "first" och "last" pekar mot första nod.
        Nodens referens "next" och "prev" pekar mot referens "first" och då blir nod dubbel-länkad */

        //gäller för skapade av noder >= 2
        else{
            last = new Node();              //skapa en ny nod med referens last.
            last.item = item;               //lägg element (tecken som skickas in i metod) i nod.
            last.next = first.next;         //noden last referens "next" pekar mot den sista noden
            last.prev = first;              //noden last referens "prev" pekar mot den första noden i listan.
            first.next = last;              // first.next pekar mot den sista noden, senaste tillgada noden.
            last.next.prev = last;          // sista noden pekar mot senaste sista nod, dess prev pekar tillbaka till last.
            N++;                            //öka antal element i lista med 1.
        }
        /*när ovan är klar kommer vi att binda senaste tillagda noden men resterande noder i listan så att
        får en dubbel-länkad (cirkulär) lista.
         */
    }
    //egen kod, metod tar bort första noden från listan
    public void dequeue() {
        //Om lista är tom, printa meddelande och hoppa ur metod
        if( isEmpty()){
            System.out.println("No nodes to dequeue!");
            return;
        }

        first = first.prev;         // first pekar nu mot nod nr 2 i listan (nästförst)
        first.next = last;          // nya first pekar mot den sista noden last
        last.prev = first;          // noden last referens "prev" pekar mot den nya första noden
        N--;                        //minska antalet element i nodlistan med 1

        //om sista noden i listan tas bort, nollställ first och last till null
        if (N == 0){
            first = null;
            last = null;
        }

    }
    //egen kod, metod ger oss en representation av innehåll i nodlistan
    public String convertToString(){

        //om nodlistan är tom, printa meddelande
        if (isEmpty()){
            return "SB: Node list empty";
        }

        StringBuilder string = new StringBuilder("[");

        //om det bara finns en nod, avsluta SB med ]
        if(N == 1){
            string.append(first.item).append("]");
        }
        //index sätt till den sista noden i kön, lägg item plus ',' i SB tills vi når första noden
        else{
            Node index = last;

            while(index != first) {
                string.append(index.item).append(", ");
                index = index.next;
            }
            string.append(index.item).append("]");
        }

        return string.toString();
    }

    //metod returnerar ett objekt av typ iterateNode som implementerar ListIterator
    public ListIterator<Item> iterator(){
        return new iterateNode();
    }

    //inbyggd class implementerar Listiterator enligt java.util.
    // Då lista är dubbellänkad kan vi gå runt listan framåt och bakåt
    private class iterateNode implements ListIterator <Item>{

        private Node iteratorNode = first;

        //metod returnerar innehåll i nodlista, rör sig bakåt i kön
        @Override
        public Item next() {

            if (isEmpty()){
                System.out.println("Node list empty, iteration not possible");
                return null;
            }

            else{
                iteratorNode = iteratorNode.prev;
                Item item = iteratorNode.item;
                System.out.println("Current item: " + item);
                return item;
            }

        }
        //metod returnerar innehåll i nodlista, rör sig framåt i kön
        @Override
        public Item previous() {

            if (isEmpty()){
                System.out.println("Node list empty, iteration not possible");
                return null;
            }

            else{
                iteratorNode = iteratorNode.next;
                Item item = iteratorNode.item;
                System.out.println("Current item: " + item);
                return item;
            }
        }

        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public boolean hasNext() {
            return false;
        }

        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public boolean hasPrevious() {
            return false;
        }

        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public int nextIndex() {
            return 0;
        }
        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public int previousIndex() {
            return 0;
        }
        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public void remove() {

        }
        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public void set(Item item) {

        }
        //Används ej, krävs att det finns med enligt java Iterator
        @Override
        public void add(Item item) {

        }
    }

    /*

    public iteratorDoubleLinked<Item> interatorDoubleLinked(){
        return new iterateList(first);
    }

    private class iterateList implements iteratorDoubleLinked<Item> {

        private Node iteratorNode;

        public iterateList (Node first){

            if (isEmpty()){
                System.out.println("Node list empty, please insert items in queue");
            }
            else
                iteratorNode = first;
        }

        //Itererar "bakåt" i listan
        public Item next(){

            if (isEmpty()){
                System.out.println("Node list empty, iteration not possible");
                return null;
            }

            else{
            iteratorNode = iteratorNode.prev;
            Item item = iteratorNode.item;
            System.out.println("Current item: " + item);
            return item;
            }
        }

        //Itererar "framåt" i listan
        public Item prev(){

            if (isEmpty()){
                System.out.println("Node list empty, iteration not possible");
                return null;
            }

            else{
            iteratorNode = iteratorNode.next;
            Item item = iteratorNode.item;
            System.out.println("Current item: " + item);
            return item;
            }
        }

    }*/

}

