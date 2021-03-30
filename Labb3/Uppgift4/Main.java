package Uppgift4;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws IOException {


        //Läser av "thetext"
        File theText = new File("/Users/stefangarrido/Desktop/Java/SearchingLab/src/Uppgift2/thetext.txt");
        FileReader fr = new FileReader(theText);
        BufferedReader br=new BufferedReader(fr);
        BSST <String, Integer> bsst = new BSST<>(30000);


        char ch;
        StringBuilder sb = new StringBuilder();
        String key;
        int index = 0;      //används för att räkna antal tecken
        int c;

        //while loopen avlsutas om vi får -1, dvs EOF
        while((c = br.read()) != -1){

            ch = (char) c;

            //Kontrollerar om tecken är alfabetiskt, om ja appenda till stringbuilder
            if(Character.isAlphabetic(ch))
                sb.append(ch);

            //kontrollerar om vi har ett ord större än 0, filtrerar bort icke-alfabetiska tecken
            else if(sb.length() > 0){
                key = sb.toString().toLowerCase();
                bsst.put(key, (index - key.length()));
                //återställ stringbuilder
                sb.delete(0, sb.length());
            }
            
            //räknar ej med newline
            /*if (ch == '\r')
                continue;*/
            
            index++;
        }

        //Scanner används för att få inmatning av användaren
        Scanner string = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int i;

        //Loop körs till vi matar in ett heltal som inte är = 1
        while(true)
        {
            System.out.println("Type 1 to enter a word. Type any integer to exit");
            i = in.nextInt();

            //returnerar arraylist med sökt ord
            if (i == 1) {
                System.out.println("Enter a word:");
                String word = string.nextLine();
                System.out.println(Arrays.toString(bsst.get(word).toArray()));
            }
            else
                break;
        }
    }

}

