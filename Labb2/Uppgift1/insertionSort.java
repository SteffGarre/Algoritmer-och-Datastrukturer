package Uppgift1;

/*Tidskomplexitet för insertionsort:
* Best case: om sekvens redan är sorterad kommer vi att utföra (n-1) jämförelser och noll byte, tidskomp. t(n)€O(n).
* Worst case: ett fall då vi får worst case är då hela sekvens är omvänd (störst till minst), då gör vi antal
* jämförelser samt byte enligt: (n-1) + (n-2) +....+ 2 + 1= n*(n-1)/2 = (n^2)/2 - n/2. För stora n får vi: (n^2)/2.
* tidskomp. t(n)€O(n^2)
* Average case: i normal fall får vi en tidskomplexitet på ((n^2)/2)/2 = (n^2)/4, t(n)€O(n^2)
* */

//klass är baserad på Princeton kod
public class insertionSort{

    //Metod sort enligt Princeton kod - sorterar enligt insertionsort
    public static int sort (int[] array ) {
        int counter = 0;        //counter används för att räkna antal swaps

        for (int i = 1; i < array.length; i++) {        // i = 1 då vi vill börja jämföra från index 1

            /* j = i, dvs inre loop jämför index i med index i-1, less kollar om index i är mindre än i-1, i-2, osv...
            om vi uppfyller krav för for loopen byter vi plats på jämförda tal, plussar antal swaps och testar vidare */
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);
                counter++;
            }
            //kallar på metod show för att printa nuvarande array
            show(array);
        }
        return counter;     //returnerar antal swaps, enligt uppgift 2
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
    //metod enligt Princeton kod - printar ut array i en rad
    private static void show (int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    /*egen kod - metod tar en array, går igenom hela arrayen och kontrollerar efter inversions, enl. uppg. 3.
    Då metod går igenom varje element i array och jämför enligt:
    (n-1) + (n-2) + (n-3) +....+ 2 + 1= n*(n-1)/2 = n^2/2 - n/2, detta ger en tidskomplexitet på: n^2/2 */
    public static void inversion (int [] a){


        StringBuilder string = new StringBuilder();     //SB används för att spara vår resultat
         int nrOfInv = 0;                                //räknar antal inversions

        //yttre loop itererar igenom alla index i array
        for(int i = 0; i < a.length; i++){

            //inre loop jämför index i med i+1,i+2, osv....
            for (int j = (i + 1); j < a.length; j++){

                //Om index i är större än (i + n), då har vi en inversion, resultat läggs i SB
                if(a[i] > a[j]){
                    string.append("[" + i + "," + a[i]+"]" + ",["+ j + "," + a[j]+"]  ");
                    nrOfInv++;
                }
            }

        }
        //Vi printar till slut vår resultat i SB samt antal inversions
        System.out.println(string.toString());
        System.out.println("# of inversions: " + nrOfInv);
    }

}


