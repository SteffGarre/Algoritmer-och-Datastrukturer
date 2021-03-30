package Uppgift4;
import java.util.Iterator;

//klass baserad på Princeton kod
public class nodeList <Item> {

    private Node last;
    private Node New;
    private int N;      // Antal Items i nod-listan

    // inbyggd class för att definera noder enligt Princeton kod.
    private class Node {
        private Item item;
        private Node next;

    }
    //enligt Princeton kod
    public boolean isEmpty() {

        return N == 0;
    }
    //egen kod, metod skapar en första nod med referens last, dvs sista noden i kön
    public void createFirstNode (Item item){
        if (isEmpty()){
            last = new Node();          //referens last pekar mot ny nod
            last.item = item;           //lägg element item i nod
            last.next = last;           //noden last pekar på last, dvs sig själv (cirkulär nod lista)
            N++;                        //öka antal element i lista med 1.
        }
        // Om N > 0, printa meddelande
        else
            System.out.println("First node already created!");
    }

    //egen kod, metod lägger till nod på första platsen i kön
    public void addFront (Item item) {
        // Om N = 0, printa meddelande
        if(isEmpty()){
            System.out.println("No node to add to, create a node!");
        }

        else{
            New = new Node();           //referens New pekar mot ny nod
            New.item = item;            //lägg element item i nod
            New.next = last.next;       //nod New pekar mot last.next, dvs den första noden
            last.next = New;            //sista noden last pekar mot nya noden New
            N++;                        //öka antal element i lista med 1.
        }
    }
    //egen kod, metod lägger till nod på sista platsen i kön
    public void addBack (Item item) {
        // Om N = 0, printa meddelande
        if(isEmpty()){
            System.out.println("No node to add to, create a node!");
        }

        else{
            New = new Node();           //referens New pekar mot ny nod
            New.item = item;            //lägg element item i nod
            New.next = last.next;       //nod New pekar mot last.next, dvs den första noden
            last.next = New;            //sista noden last pekar mot nya noden New
            last = New;                 //nod New sätts till nya sista nod, dvs last
            N++;                        //öka antal element i lista med 1.
        }
    }
    //egen kod, metod tar bort den första noden i kön
    public void removeFront() {
        // Om N = 0, printa meddelande och låt referens last peka mot null
        if(isEmpty()){
            System.out.println("No node to remove, create a node!");
            last = null;
        }
        // sista noden last pekar mot näst nästa nod, dvs nod nr 2 i listan och tar därmed bort första noden.
        else{
            last.next = last.next.next;
            N--;}                           //misnka antal element i lista med 1.
    }
    //egen kod, metod tar bort den sista noden i kön
    public void removeBack() {
        // Om N = 0, printa meddelande och låt referens last peka mot null
        if(isEmpty()){
            System.out.println("No node to remove, create a node!");
            last = null;
        }

        else{
            Node index = last.next;             // index pekar till första noden i kön

            while (index.next != last){         //while loopen körs tills vi når näst sista nod i kön.
                index = index.next;
            }
            index.next = index.next.next;       //låt näst sista nod peka mot första nod och dörmed radera sista noden.
            last = index;                       //näst sista noden sätt till sista noden
            N--;                                //minska antal element i lista med 1.
        }

    }

    //egen kod
    public String convertToString(){
        //Om N = 0, hoppa ur metod.
        if (isEmpty()){
            return "SB: Node list empty";
        }
        //skapa en stringbuilder med ett första tecken '['.
        StringBuilder string = new StringBuilder("[");

        //specialfall då vi bara har en nod i listan lägg till ']' på slutet.
        if(N == 1){
            string.append(last.item).append("]");
        }

        /*  while loop körs sä länge inte index = last,
        lägg till element i nuvarande nod och sedan ',' */
        else{

            Node index = last.next;

            while(index != last) {
                string.append(index.item).append(", ");
                index = index.next;
            }
            //lägg till ']' på slutet
            string.append(index.item).append("]");
        }
        //omvanlda SB till en sträng och returnera
        return string.toString();
    }

    //metod returnerar ett objekt av typ iterateNode som implementerar javas Iterator
    public Iterator <Item> iterator(){

        return new iterateNode();
    }

    //inbyggd class implementerar Iterator enligt java.util.
    // Då nodlista är enkellänkad (cirkulär) kan vi gå runt listan framåt
    private class iterateNode implements Iterator <Item>{

        private Node iteratorNode = last;

        @Override
        //metod next låter oss iterera från första noden och framåt
        public Item next() {
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

    }
}




