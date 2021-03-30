package Uppgift3;
import java.util.Iterator;
import java.util.NoSuchElementException;

 /* Tar emot antalet hörn som finns i grafen och initierar pq och qp array för den storleken.
    PQ innehåller vilka hörn som hör till vilken prioritetsplats och QP innehåller det omvända,
    dva vilken prioritet varje hörn har. NOtera att indexplats 1 i PQ är den högsta prioritet */

//Klassen är baserad på Princeton kod
public class IndexMinPQ <Key extends Comparable<Key>> implements Iterable<Integer> {

    private int n;           // antal element i pq
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;      // innehåller tot. weight från startpunkt

    //constructor som sätter upp arrays: keys, pq och qp
    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];

        //sätter alla indexplatser i qp till -1
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    //kollar om det finns element i pq.
    public boolean isEmpty() {
        return n == 0;
    }

    // Kollar om ett hörn existerar i priority queuen genom att kolla om qp har uppdaterats med dess prioritet
    public boolean contains(int i) {

        return qp[i] != -1;
    }


    // Tar emot ett hörn och dess avstånd till starthörnet. qp innehåller prioriteringen för varje hörnplats medans
    // pq har koll på vilket hörn som hör till respektive prioritetsordning, alltså index1 är högst prioritering.
    // Keys innehåller totala weighten från source. n vilken prioritet som är aktuell.
    public void insert(int i, Key key) {

        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }


    // Returnerar det objekt som har högst prioritet. Uppdaterar sedan kö med exch som flyttar
    // fram nästa objekt och sätter sedan qp på dess plats till -1 igen för att ta bort det ur kö.
    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // tar bort, deletar från pq
        keys[min] = null;    // för att hjälpa med garbage collector
        pq[n+1] = -1;        // behövs ej
        return min;
    }

    // Funktion för att uppdatera och minska key(weight) till ett visst hörn, kallar på swim.
    public void decreaseKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
    }

    // Jämförelse av pq hörnens weight.
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    // Byter plats i prioritets kön.
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    // swim och sink hjälper till om heap order blir förändrad där ett hörns key(weight) i pq
    // blir större/mindre än vad motsvarande borde ha enligt prioritetskön för en min-heap.
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    //Heap iterator
    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {

        // skapa en ny pq
        private IndexMinPQ<Key> copy;


        //lägg alla elements till "copy" av heap
        //detta utförs enligt linjärt tid efter som det är ordnat enligt heap så inga keys behöver flyttas om
        public HeapIterator() {
            copy = new IndexMinPQ<>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }
        //kollar om det
        public boolean hasNext()  { return !copy.isEmpty();
        }
        //används ej
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
