package Uppgift4;
import java.util.ArrayList;

//Klass är enligt en Binary Search Symbol Table enligt Princeton kod
public class BSST <Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private ArrayList<Value>[] value;       //en modifiering är att värde sparas i en ArrayList
    private int n = 0;
    private static final int init_size = 2;


    public BSST() {
        this(init_size);
    }

    //Capacity initierar storleken för keys och value
    public BSST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        value = new ArrayList[capacity];

        for (int i = 0; i < capacity; i++) {
            value[i] = new ArrayList<>();
        }
    }
    /*
    private void resize(int capacity)
    {
        Key[] tempkeys = (Key[]) new Comparable[capacity];
        ArrayList<Value>[] tempvalues = (ArrayList<Value>[]) new Object[capacity];
        for (int i = 0; i < n; i++)
        {
            tempkeys[i] = keys[i];
            tempvalues[i] = value[i];
        }
        value = tempvalues;
        keys = tempkeys;
    }*/


    //Get antal ord i datastrukturen
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    //Då varje ord har en mostvarande ArrayList returnerar metoden en ArrayList
    public ArrayList<Value> get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;

        //kallar metoden rank
        int i = rank(key);

        //om det finns ett sökt ord i datastrukturen, returnerar dess ArrayList
        if (i < n && keys[i].compareTo(key) == 0)
            return value[i];
        return null;
    }

    //rank returnerar en integer som motsvarar en index i datastrukturen
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");

        //jämförelsen är byggd på så viss att vi inte jämför hela arrayen keys, sökning splittas upp istället.
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }


    //Metoden tar ett ord och beröknar dess rank, om denna finns lägg in
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");


        int i = rank(key);

        // ord finns redan i datastrukturen, lägg till "antal tecken" i dess ArrayList
        if (i < n && keys[i].compareTo(key) == 0) {
            value[i].add(val);
            return;
        }

        // insert new key-value pair
       // if (n == keys.length)
         //      resize(2*keys.length);

        //baserad på rank flyttas keys och value om så att ordning blir rätt
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            value[j].addAll(value[j-1]);
            value[j-1].clear();
        }

        //lägg in ord samt antal tecken i motsvarande index.
        keys[i] = key;
        value[i].add(val);
        n++;
    }

}