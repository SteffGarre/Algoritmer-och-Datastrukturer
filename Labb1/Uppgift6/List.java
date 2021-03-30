package Uppgift6;

//klass är baserad på Princetons kod för listor
public class List {

    private Node first;
    private Node New;
    private int N;      // Antal Items i nod-listan

    private class Node {    // inbyggd class för att definera noder enligt Princeton kod.
        private int item;
        private Node next;

    }

    //enligt Princeton kod
    public boolean isEmpty() {

        return N == 0;
    }

    //egen skriven kod
    public void addNode (int integer) {

        //Om N = 0 skapa en ny nod
        if (isEmpty()){
            first = new Node();             //första noden får referens first
            first.item = integer;           //lägg element integer i nod
            first.next = null;              // noden first referens "next" pekar mot null
            N++;                            //öka antal element i lista med 1.
            return;
        }
        //Skapa en ny nod om N >=1 och lägg element integer i nod.
        New = new Node();
        New.item = integer;

        // Specialfall då ny element är >= än första element i listan.
        if (New.item <= first.item ){
            New.next = first;               //nod New referens "next" pekar mot första noden i listan.
            first = New;                    //nod New blir första noden i listan med referens first.
            N++;                            //öka antal element i lista med 1.
            return;
        }

        //Kopiera referens till first och använd referens för att iterera listan.
        Node index = first;

        //Utför så länge den nuvarande indexs next inte pekar mot null.
        while(index.next != null) {

            //Om den nyinlagda heltal >= än nösta nod i listans heltal, breaka loop.
            if (New.item <= index.next.item){
                break;
            }

            index = index.next;
        }

        // Ny nod läggs framför (till höger om) den nuvarande index.
        New.next = index.next;
        index.next = New;
        N++;
    }

    //egen skriven kod
    public void removeNode(int counter) {

        //Om N = 0, hoppa ur metod
        if(isEmpty()){
            System.out.println("No node to remove, create a node!");
            return;
        }

        //Om counter (eg önskad index) ej existerar - hoppa ur metod
        if(counter > N | counter <= 0){
            System.out.println("index do not exist!");
            return;
        }

        // Kontroll görs om counter (eg önskad index) är = 1
        if(counter == 1){
            // Om det bara finns 1st nod i listan, nollställ first till null
            if (N == 1){
                first = null;
                N--;}
            //Om N > 1, ta bort första element och lägg first på nästa nod i listan.
            else{
                first = first.next;
                N--;}
        }

        // Tar bort element då önskad index > 1
         else{
            // j sätts till 2 då vi endast vill jämföra från index 2
            int j = 2;
            Node index = first;

            while(j < counter){
                index = index.next;
                j++;
            }
            //den nuvarande indexs next sätts lika med näst-nästa nod, på så sätt "raderas" önskad nod.
            index.next = index.next.next;
            N--;
        }
    }

    //egen skriven kod
    public String convertToString(){
        //Om N = 0, hoppa ur metod
        if (isEmpty()){
            return "SB: Node list empty";
        }

        //skapa en stingbuilder med ett första tecken [
        StringBuilder string = new StringBuilder("[");

        //specialfall då vi bara har en nod i listan
        if(N == 1){
            string.append(first.item).append("]");
        }

        //  while loop körs sä länge inte nästa är null, lägg till ',' och avsluta med ].
        else{
            Node index = first;

            while(index.next != null) {
                string.append(index.item).append(", ");
                index = index.next;
            }
            string.append(index.item).append("]");
        }
        //konvertera stringbuilder till en string och returnera
        return string.toString();
    }

}
