package Uppgift3;
import java.util.Iterator;
import java.util.NoSuchElementException;

//KLassen är enligt PRinceton Kod
public class BagEdge<Item> implements Iterable<Item>{

    private Node<Item> first;    // början av bag
    private int n;               // nantal element i bag


    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //Initierar en tom bag
    public BagEdge() {
        first = null;
        n = 0;
    }


    //Add lägger till en länkad nod i bag-listan, där den senaste tillagda nod är first.
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    //Iteratpr hjälper oss att traversera noder i bag-listan
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }


    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        //Kollar att det finns en nästa nod
        public boolean hasNext() {
            return current != null;
        }

        //används ej
        public void remove() {
            throw new UnsupportedOperationException();
        }

        //Itererar igenom till nästa nod om if sats uppfylls
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

}
