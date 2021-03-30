package Uppgift1;
import java.util.Iterator;
import java.util.NoSuchElementException;


//Baserad på Princetons kod, Bag ger oss  länkade nodlistor till adj[] i Graph (dvs en bag till varje adj[] )
public class Bag <Item> implements Iterable<Item>{

    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag


    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    //lägger till en ny nod, den nya noden blir det nya first.
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    //iterator för bag-listan
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }


    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        //sätter noden current till first
        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        //kollar om nästa pekar mot null
        public boolean hasNext() {
            return current != null;
        }

        //används ej
        public void remove() {
            throw new UnsupportedOperationException();
        }

        //Låter oss iterera genom nodlistan och returnerar nodens item.
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

}
