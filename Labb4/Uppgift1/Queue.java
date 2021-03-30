package Uppgift1;
import java.util.NoSuchElementException;

//Klassen är enligt Princeton kod
public class Queue<Item> {
    private Node<Item> first;    // början av kön
    private Node<Item> last;     // slutet av kön
    private int n;               // antal element i kön


    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    //Initierar en tom kö
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    //kollar om kön är tom
    public boolean isEmpty() {
        return first == null;
    }


    //Metod lägger ny nod längst bak i kön, om kön är tom så är den tillagda noden både first och last.
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    //Vid dequeue av kön så tar vi bort nod med pekare "first", nr 2 i kön blir ny first.
    //om noden som tas bort är den sista i kön lägger vi last till null för att undvika loitering.
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;   // för att undvika loitering
        return item;
    }


}
