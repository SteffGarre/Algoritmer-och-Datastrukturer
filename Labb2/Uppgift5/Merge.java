package Uppgift5;
import java.util.Arrays;

//klass baserad på Princeton kod
public class Merge {

    // kod är enligt Princeton kod
    private Merge() {
    }

    /* metod slår ihop resultat från sortSecond, när vi lämnar metod uppdateras array a
    med rätt sorterad partition */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        // kopierar partition till aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
       // System.out.println("aux array: " + Arrays.toString(aux) + "\n");

        // uppdaterar värde i array a[k] enligt villkor som uppfylls, aux har sparade värde så att inget förloras.
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else{
                a[k] = aux[i++];}

            //System.out.println("During for-loop: " + Arrays.toString(a));
        }

        //System.out.println("\nEnd of merge - Array a " + Arrays.toString(a) + "\n");

    }

    // metod kallas rekursivt
    private static void sortSecond(int[] a, int[] aux, int lo, int hi) {

        //if sats for vanlig mergesort, kontrollerar om vi har nått en partition där vi bara har en element kvar
        if (hi <= lo) return;

        //OBS!Detta måste kommenteras bort om cut-off ska användas
        //if sats för cutoff av merge mha av insertionsort
        //cutoff ger oss en partition av en bestämd storlek, tex: 10

        /*if ((hi-lo) <= 10){
            insertionSort2.sort(a,lo,hi);
            return;
        }*/

        //mid motsvarar mitten av en array (eller början/slutet av en partition när metod kallas rekursivt)
        int mid = lo + (hi - lo) / 2;

        //delar upp vänstra halvan av array - kallas rekursivt tills vi når vår base case (hi <= lo)
        sortSecond(a, aux, lo, mid);

        // delar upp högra halvan av array - kallas rekursivt tills vi når vår base case (hi <= lo)
        sortSecond(a, aux, mid + 1, hi);

        //mergar ihop resultat
        merge(a, aux, lo, mid, hi);


    }

    //kod enligt Princeton
    // metod kallas en gång och skapar en ny array "aux" med storlek av en den inmatade array "a".
    public static void sortFirst(int[] a) {
        int[] aux = new int[a.length];
        //den rekursiva metoden kallas där vi matar in array a och aux samt index = 0 och sista index i array a.
        sortSecond(a, aux, 0, a.length - 1);
    }


    //metod enligt Princeton kod - jämför två tal, returnerar true om v < w
    private static boolean less(int v, int w) {
        return v < w ;
    }


    //metod enligt Princeton kod - printar ut array i en rad
     static void show (int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

}
