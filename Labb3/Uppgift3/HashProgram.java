package Uppgift3;
import Uppgift2.BinarySearchST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashProgram {

        public static void main (String [] args) throws FileNotFoundException {

        File theText = new File("/Users/stefangarrido/Desktop/Java/SearchingLab/src/Uppgift2/thetext.txt");
        Scanner text = new Scanner(theText);

        Scanner input = new Scanner(System.in);
        System.out.println("Number of words?: ");
        int n = input.nextInt();
        BinarySearchST<String, Integer> bsst = new BinarySearchST<>(n);

        int m = 19;
        int[] Hash = new int[m];    //Förvarar dom modifierade hashkoder enligt nedan.
        int minWord = 2;
        int counter = 0;
        int hashcode;
        int distinct = 0;

        while(text.hasNextLine() && counter < n)
        {

            String key = text.next().toLowerCase();

            //Rensar från icke alfabetiska tecken i början och slutet av ett ord.
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0,key.length()-1);
            if(!Character.isAlphabetic(key.charAt(0)))
                key = key.substring(1);

            //Kontrollerar om key är mindre än minsta antal bokstäver i ett ord, skippa iteration
            if(key.length() < minWord)
                continue;

            //Om det är första gången ordet uppstår, gör om dess hashkod och lägg till i Hash.
            if(!bsst.contains(key)){
                hashcode = ((key.hashCode() & 0x7fffffff) % m);
                bsst.put(key,hashcode);
                distinct++;
                Hash [hashcode] += 1;
            }

            counter++;
        }

        //Printar ut array Hash som motsvarar fördelningen av javas egna hashcode()
        int x = 0;
        while (x < m){
            System.out.println("Hash " + x + " has size: " + Hash[x]);
            x++;
        }
        System.out.println("Number of distinct words: " + distinct);


    }
}
