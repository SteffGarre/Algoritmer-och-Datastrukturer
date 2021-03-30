package Uppgift5;
import java.util.Random;


public class program2 {
    public static void main(String[] args){

        //Test som genererar heltal från -10 till 10 och lagrar dessa i en array.
        Random rand = new Random();

        int min =-10;
        int max = 11;
        int N = 16;
        int [] x = new int[N];
        int a = 0;

        while (a < N){
            x [a] = (rand.nextInt(max - min) + min);
            a++;
        }
        System.out.println("Array before sorting:");
        Merge.show(x);

        //nanoTime tillåter oss ta tid på exekvering av sorteringsalogirtmen
        long startTime = System.nanoTime();
        Merge.sortFirst(x);
        long stopTime = System.nanoTime();
        System.out.println("Time: " + ((stopTime - startTime) * 0.000000001) + " sekunder");

        //Printar ut innehåll i array. Obs! bör kommenteras bort om variabel N testas för stora tal.
        System.out.println("Mergesort :");
        Merge.show(x);


    }
}
