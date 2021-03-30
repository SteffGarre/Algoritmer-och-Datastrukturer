package Uppgift1;
import java.util.Iterator;
import java.util.NoSuchElementException;

//KLassen är enligt Princeton Kod
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;     // toppen av Stack
    private int n;                // storlek av Stack


    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //Initierar en tom Stack
    public Stack() {
        first = null;
        n = 0;
    }

    //Push metoden är enligt LIFO-system, varje ny nod blir first (toppen av stacken)
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    //En iterator som hjälper oss att traversera nodlistan som pushas, börjar med first (toppen av stack)
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }
        // Kollar om det finns en nästa nod
        public boolean hasNext() {
            return current != null;
        }

        //Denna används ej
        public void remove() {
            throw new UnsupportedOperationException();
        }

        //Hämtar nodens item (heltalsrepresentation)
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}

