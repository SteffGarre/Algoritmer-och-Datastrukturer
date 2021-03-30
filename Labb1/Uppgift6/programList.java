package Uppgift6;


import java.util.Scanner;

public class programList {

    public static void main (String [] args){

        System.out.println("Test");
        Scanner inputInt = new Scanner(System.in);      //scanner låter oss ta input från keyboarden.
        boolean i = true;

        List queue = new List();                        //skapar ett objekt av typ List med referens queue

        /*while loop körs tills vi ändrar variabel i till false.
        Loop gör det möjligt att kontinuerligt testa att lägga/ta bort noder
        utan att behöva starta om program. */

        while (i) {

            System.out.println("\nType 1 to add node, 2 remove node, 3 end program");
            int in = inputInt.nextInt();

            switch (in) {
                case 1:
                    System.out.println("Input integer");
                    int integer = inputInt.nextInt();       //integer sparar senaste skrivna heltal
                    queue.addNode(integer);                 //lägg till heltal i en nod mha addNode metoden.
                    System.out.println("Content: " + queue.convertToString()); //printar nodlista mha convertToString
                    break;

                case 2:
                    System.out.println("Input index you wish to remove");
                    int counter = inputInt.nextInt();  //counter sparar senaste skrivna heltal
                    queue.removeNode(counter);         //skickar heltal counter till metod remodeNode
                    System.out.println("Content: " + queue.convertToString()); //printar nodlista mha convertToString
                    break;
                case 3:
                    i = false;
                    break;

            }
        }
    }
}
