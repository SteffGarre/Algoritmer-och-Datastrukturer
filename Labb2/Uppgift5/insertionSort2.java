package Uppgift5;

/*Tidskomplexitet för insertionsort:
* Best case: om sekvens redan är sorterad kommer vi att utföra (n-1) jämförelser och noll byte, tidskomp. t(n)€O(n).
* Worst case: ett fall då vi får worst case är då hela sekvens är omvänd (störst till minst), då gör vi antal
* jämförelser samt byte enligt: (n-1) + (n-2) +....+ 2 + 1= n*(n-1)/2 = (n^2)/2 - n/2. För stora n får vi: (n^2)/2.
* tidskomp. t(n)€O(n^2)
* Average case: i normal fall får vi en tidskomplexitet på ((n^2)/2)/2 = (n^2)/4, t(n)€O(n^2)
* */



//klass är baserad på Princeton kod
public class insertionSort2 {

    //Metod sort enligt Princeton kod - sorterar enligt insertion sort.
    //Metod är anpassad för att hantera mergesort, därav tar metod även int low och high.
    public static void sort (int[] array, int low, int high) {

        for (int i = low + 1; i <= high; i++) {        // i = low + 1 då vi vill börja jämföra från index low + 1.

            /* j = i, dvs inre loop jämför index i med index i-1, less kollar om index i är mindre än i-1, i-2, osv...
            om vi uppfyller krav för for loopen byter vi plats på jämförda tal, plussar antal swaps och testar vidare */
            for (int j = i; j > low && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);

            }
        }
        //System.out.println("insertionsort:" + Arrays.toString(array) + "\n");
    }

    //metod enligt Princeton kod - jämför två tal, returnerar true om v < w
    private static boolean less(int v, int w) {
            return v < w ;
    }

    //metod enligt Princeton kod - byter plats mellan två heltal i array mha en temporör variabel
    private static void swap(int[] a, int i, int j) {
             int temp = a[i];       //spara heltal i en temporär variabel
             a[i] = a[j];           //lägger nytt heltal i plats a[i]
             a[j] = temp;           //lägger sparad heltal i a[j]
    }

}


