package Uppgift3;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Klass är baserad på Princeton Kod
public class StackEdge<Item> implements Iterable<Item> {

    private Node<Item> first;     // toppen av stack
    private int n;                // stack-storlek

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

   //Initierar en tom stack
    public StackEdge() {
        first = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    //En iterator används för att kunna gå igenom noder i stack där first är toppen av stack
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        //Används ej
        public void remove() {
            throw new UnsupportedOperationException();
        }

        //Ger oss nästa nod i stack
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}

