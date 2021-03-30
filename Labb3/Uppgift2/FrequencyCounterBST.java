package Uppgift2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FrequencyCounterBST {

    public static void main(String[] args) throws FileNotFoundException {

        File theText = new File("/Users/stefangarrido/Desktop/Java/SearchingLab/src/Uppgift2/thetext.txt");
        Scanner text = new Scanner(theText);

        Scanner input = new Scanner(System.in);
        System.out.println("Number of words?: ");
        int n = input.nextInt();

        BST<String, Integer> bst = new BST<>();
        int minlen = 2;     //Sätter minsta antal bokstäver i ett ord
        int counter = 0;    //används för att stoppa while loop nedan.
        int distinct = 0;   //Räknar antal olika ord

        //Används för att "balancera" träd,
        //bokstaven H har värde 0 vilket kommer att ersättas redan av första ordet som den mest frekventa.
        String mostFreq = "H";
        bst.put(mostFreq, 0);

        long startTime = System.nanoTime();

        while (text.hasNextLine() && counter < n) {

            String key = text.next().toLowerCase();

            //Rensar från icke alfabetiska tecken i början och slutet av ett ord.
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0,key.length()-1);
            if(!Character.isAlphabetic(key.charAt(0)))
                key = key.substring(1);

            //Kontrollerar om key är mindre än minsta antal bokstäver i ett ord, skippa iteration
            if (key.length() < minlen)
                continue;

            //Om det är första ggn ordet uppstår, lägg till.
            if (!bst.contains(key)) {
                bst.put(key, 1);
                distinct++; }

            //Om ord redan finns, plussa upp nuvarande värde
            else
                bst.put(key, bst.get(key) + 1);

            //håller reda på den mest frekventa ordet
            if (bst.get(key) > bst.get(mostFreq))
                    mostFreq = key;

            counter++;
        }

        long finishTime = System.nanoTime();

        System.out.println("Time elapsed: " + ((finishTime - startTime) * 0.000000001) + " sek");

        System.out.println("Key: "+ mostFreq + "\nKey occurs: " + bst.get(mostFreq) + " times");
        System.out.println("Number of distinct words: " + distinct);
    }

}
