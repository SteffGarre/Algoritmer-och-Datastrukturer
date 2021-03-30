package Uppgift1;
import java.util.Random;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {


        //Scanner funktion låter oss ta input från keyboard
        Scanner In = new Scanner(System.in);

        //Låter användaren bestämma storlek av input --> storlek av array
        System.out.println("Input size of integer array!");
        int size = In.nextInt();
        int [] array = new int[size];

        //Låter användaren knappa in heltal i array
        System.out.println("Input integer you wish to store in array");
        int i = 0;
        while (i < size){
            array[i] = In.nextInt();
            i++;
        }
        //Printar ut innehåll i array innan metoder används
        int y = 0;
        System.out.print("Array before sorting: [ ");
        while (y < size){
            System.out.print(array[y]);
            System.out.print(" ");
            y++;
        }
        System.out.print("]\n\n");

        //skickar array till metod "inversion"
        insertionSort.inversion(array);
        System.out.println();

        //kallar på sort och sorterar array samt printar ut antal swaps i sorteringen
        System.out.println("insertion sort:");
        System.out.println("Number of swaps: " + insertionSort.sort(array));




        //Test som genererar heltal från -10 till 10 och lagrar dessa i en array.
        Random rand = new Random();

        int min =-10;
        int max = 11;
        int N = 10;
        int [] x = new int[N];
        int a = 0;

        while (a < N){
            x [a] = (rand.nextInt(max - min) + min);
            a++;
        }

        //nanoTime tillåter oss ta tid på exekvering av sorteringsalogirtmen
        //OBS! Metod "show" i insertionSort behöver kommenteras bort innan timing utförs!
        long startTime = System.nanoTime();
        insertionSort.sort(x);
        long stopTime = System.nanoTime();
        System.out.println("Time: " + ((stopTime - startTime) * 0.000000001) + " sekunder");



    }
}
