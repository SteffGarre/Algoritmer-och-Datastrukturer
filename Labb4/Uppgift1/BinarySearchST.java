package Uppgift1;
import java.util.Iterator;

//Klass BinarySearchST är enligt princeton kod
public class BinarySearchST<Key extends Comparable <Key>, Value> implements Iterable<Key> {

    private Key[] keys;
    private Value[] values;
    private int n = 0;


    public BinarySearchST(int size)
    {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    //Kontrollerar om det finns några ord.
    public boolean isEmpty()
    {
        return n == 0;
    }

    public void put(Key key, Value value)
    {

        //kontrollera rank av ord
        int index = rank(key);

        //om ordet finns, öka nuvarande value med 1 och hoppa ur
        if(index < n && keys[index].compareTo(key) == 0)
        {
            values[index] = value;
            return;
        }

        //Flyttar om array keys och values "bakåt" för att göra plats för ett ord med lägre värde.
        for (int j = n; j > index; j--)
        {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        //Lägger in ordet med dess motsvarande värde och ökar antal ord i klassen (n).
        keys[index] = key;
        values[index] = value;
        n++;
    }

    //returnerar ett värde på sökt key (ord).
    public Value get(Key key)
    {
        if(isEmpty())
            return null;

        int index = rank(key);
        if(index < n && keys[index].compareTo(key) == 0)
            return values[index];
        else
            return null;
    }

    //rankar ord och bestämmer dess index i array keys och values.
    public int rank(Key key)
    {
        int lo = 0;
        int hi = n - 1;

        // loop delar upp sökningen, beroende på villket villkor
        // uppfylls söker vi till vänster/höger av mitten av array.
        //vi returnerar ett index plats
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            int compare = key.compareTo(keys[mid]);

            if(compare < 0)
                hi = mid - 1;
            else if(compare > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    //kontrollerar om ett ord redan finns
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    //ger ordet i första platsen i keys
    public Key min()
    {
        return keys[0];
    }


    //En iterator som låter oss gå igenom array keys, börjar vid start av keys.
    public Iterator <Key> iterator()
    {
        return new keyIterator(keys[0]);
    }

    private class keyIterator implements Iterator<Key>
    {
        Key currentKey;
        int startPos;

        private keyIterator(Key lo)
        {
            startPos = 0;
            currentKey = lo;
        }


        public boolean hasNext()
        {
            return keys[startPos + 1] != null;
        }

        public Key next()
        {
            if(hasNext())
            {
                Key key = currentKey;
                currentKey = keys[++startPos];
                return key;
            }
            else
                return currentKey;
        }
    }

}

