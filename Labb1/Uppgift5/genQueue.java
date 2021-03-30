package Uppgift5;

//klass baserad på Princeton kod
public class genQueue <Item> {

    private Node first;
    private Node New;
    private int N;      // Antal element i nod-listan

    // inbyggd class för att definera noder enligt Princeton kod.
    private class Node {
        private Item item;
        private Node next;

    }

    //enligt Princeton kod
    public boolean isEmpty() {

        return N == 0;
    }
    //egen kod, metod skapar en nod som innehåller ett generiks element (item)
    public void addNode (Item item) {
        //om N = 0 skapa en nod
        if (isEmpty()){
            first = new Node();         //referens first pekar mot första noden
            first.item = item;          //lägg generiskt element  i nod
            first.next = null;          //noden first pekar mot null
            N++;                        //öka antal element i listan med 1.
            }

        else{
            New = new Node();           //referens New pekar mot ny nod
            New.item = item;            //lägg generiskt element  i nod
            New.next = first;           //noden New pekar mot first, länkar ihop med första nod i listan
            first = New;                //referens first pekar mot noden New, New blir första nod i listan
            N++;                        //öka antal element i listan med 1.
        }
    }
    //egen kod, metod tar bort nod enligt önskad index, där index 1 = första noden.
    public void removeNode(int counter) {
        //OM N = 0 printa meddelande
        if(isEmpty()){
            System.out.println("No node to remove, create a node!");
            return;
        }
        /*Om counter (index för nodlista) är större än antal element i listan
        eller counter ör minde/lika med noll, printa meddelande */
        if(counter > N | counter <= 0){
            System.out.println("index do not exist!");
            return;
        }
        //specialfall: antigen så finns det bara 1st element kvar (dvs 1 nod) eller fler än 1st element
        if(counter == 1){
            // Om N = 1, sätt referens first till null, dvs ta bort sista nod i listan
            if (N == 1){
                first = null;
                N--;}
            // OM N > 1 sätt first på nod nr 2 i listan, därmed raderas första noden.
            else{
                first = first.next;
                N--;}
        }

        //gäller för borttagning av nod med index 2 eller större
         else{

            int j = 2;                   // j = 2 då vi vill undersöka index 2 och uppåt
            Node index = first;

            while(j < counter){         // while loopen gör att vi hamnar på noden innan vald nod för borttagning.
                index = index.next;
                j++;
            }
            index.next = index.next.next;       /*vi sätter att nod innan pekar mot näst nästa nod, dvs att vi slutar
                                                referera till vald nod för borttagning och tar därmed bort nod */
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
            string.append(first.item).append("]");
        }

        /*  while loop körs sä länge inte nästa är null,
        lägg till element i nuvarande nod och sedan ',' */
        else{

            Node index = first;

            while(index.next != null) {
                string.append(index.item).append(", ");
                index = index.next;
            }
            //lägg till ']' på slutet
            string.append(index.item).append("]");
        }
        //omvanlda SB till en sträng och returnera
        return string.toString();
    }

}
