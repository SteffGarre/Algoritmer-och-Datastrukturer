package Uppgift2;

//klass baserad på Princeton kod
public class stack {

    private Node first;
    private Node New;
    private int N;      // Antal element i nod-listan

    // inbyggd class för att definera noder enligt Princeton kod.
    private class Node {
        private char item;      //klass nod kan innehålla typen char
        private Node next;      //klass nod kan innehålla referens av typen Node
    }

    //enligt Princeton kod, returnerar true om N = 0, annars false.
    public boolean isEmpty() {

        return N == 0;
    }

    //egen kod, push skapar ny noder med chars som innehåll.
    void push(char item) {

        //Om N = 0 skapa en ny nod.
        if (isEmpty()) {
            first = new Node();     //Referens first pekar på ny nod
            first.item = item;      //lägg element (tecken som skickas in i metod) i nod
            first.next = null;      //noden first referens "next" pekar mot null.
            N++;                    //öka antal element i nod lista med 1.
            return;
        }

        New = new Node();           //skapa en ny nod med referens "New"
        New.item  = item;           //lägg element (tecken som skickas in i metod) i nod
        New.next = first;           //noden News referens "next" pekar mot first och därmed länkar ihop noder.
        first = New;                //referens first pekar nu mot nod New, denna blir nu den första noden i listan.
        N++;                        //öka antal element i nod lista med 1.
    }


    char pop() {
        char x = first.item;        //lägg element i nod som refereras av first i x.
        first = first.next;         //referens first ändras nu till nästa nod i listan, därmed tas första nod bort.
        N--;                        //minska antal element i nod lista med 1.
        return x;
    }

}

