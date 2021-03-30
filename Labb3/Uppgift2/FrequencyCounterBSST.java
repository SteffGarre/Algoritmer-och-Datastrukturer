package Uppgift2;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;


public class FrequencyCounterBSST {

    public static void main (String[] args) throws FileNotFoundException {

        //Läser av "thetext"
        File theText = new File("/Users/stefangarrido/Desktop/Java/SearchingLab/src/Uppgift2/thetext.txt");
        Scanner text = new Scanner(theText);

        //Tar input från användaren och sätter en maxgräns på antal lästa ord
        Scanner input = new Scanner(System.in);
        System.out.println("Number of words?: ");
        int n = input.nextInt();


        BinarySearchST <String, Integer> st = new BinarySearchST<>(n);

        int minlen = 2;  //Sätter minsta antal bokstäver i ett ord
        int counter = 0; //används för att stoppa while loopen nedan
        int distinct = 0;

        //nanoTime används för att ta tid på exekveringstid av insert av element
        long startTime = System.nanoTime();
        while(text.hasNextLine() && counter < n)
        {
            String key = text.next().toLowerCase();

            //Rensar från icke alfabetiska tecken i början och slutet av ett ord.
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0,key.length()-1);
            if(!Character.isAlphabetic(key.charAt(0)))
                key = key.substring(1);

            //Kontrollerar om key är mindre än minsta antal bokstäver i ett ord, skippa iteration
            if(key.length() < minlen)
                continue;

            //Om det är första ggn ordet uppstår, lägg till.
            if(!st.contains(key)){
                st.put(key,1);
                distinct++;}

            //Om ord redan finns, plussa upp nuvarande värde
            else
                st.put(key,st.get(key) + 1);

            counter++;
        }

        long finishTime = System.nanoTime();

        System.out.println("Time elapsed: " + ((finishTime - startTime) * 0.000000001) + " s");



        //Hitta ord som uppstår flest ggr, itererar genom array of keys och kollar varje ord och dess värde.
        Iterator itr = st.iterator();

        //sätt första ordet till det ordet som uppstår flest ggr.
        String word = st.min();
        int maxValue = st.get(word);
        String current;

        for(int i = 0; i < n - 1; i++)
        {
            current = (String) itr.next();
            if(maxValue < st.get(current))
            {
                word = current;
                maxValue = st.get(current);
            }
        }

        System.out.println("Key: "+ word + "\nKey occurs: " + maxValue + " times\n" +
                "Number of distinct words: " + distinct);
    }
}

