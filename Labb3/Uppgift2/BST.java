package Uppgift2;
import java.util.NoSuchElementException;

//klass enligt Princeton kod
public class BST<Key extends Comparable <Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    //Initializes an empty symbol table.
    public BST() {
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.size;
    }
    //metod kallar på get() för att hitta sökt ord
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    //när get kallas första gången skickas sökt ord + roten till den andra get()
    public Value get(Key key) {
        return get(root, key);
    }


    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null)
            return null;

        //jämför sökt ord med nuvarande nods ord
        int cmp = key.compareTo(x.key);

        //villkor nedan kallas rekursivt

        //gå vänster i subtree
        if      (cmp < 0)
            return get(x.left, key);
        //gå höger i subtree
        else if (cmp > 0)
            return get(x.right, key);
        //im inget av ovan stämmer har vi hittat sökt ord
        else
            return x.val;
    }


    public void put(Key key, Value val) {

        if (key == null)
            throw new IllegalArgumentException("calls put() with a null key");

        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        //OM ord ej finns i datastruktur, skapa en ny nod och öka dess värde med 1.
        if (x == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        //villkor nedan kallas rekursivt

        //gå vänster i subtree
        if      (cmp < 0)
            x.left  = put(x.left, key, val);
        //gå höger i subtree
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        //im inget av ovan stämmer har vi hittat sökt ord
        else
            x.val = val;

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
}

