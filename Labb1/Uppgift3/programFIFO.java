package Uppgift3;

import java.util.ListIterator;

public class programFIFO {

    public static void main(String[] args){


        System.out.println("TEST");
        //scanner låter oss ta input från keyboard
        java.util.Scanner inputInt = new java.util.Scanner(System.in);
        java.util.Scanner inputString = new java.util.Scanner(System.in);
        boolean i = true;

        //skapa ett objekt av typ Queue med referens test
        Queue <String> test = new Queue<>();

        /*while loopen körs tills variabel i öndras till false. Loopen gör det möjligt att kontinuerligt
        * testa att lägga till/ta bort noder utan att starta om program*/
        while (i){

            System.out.println("\nType 1 for enqueue, 2 for dequeue, 3 for iterator, " +
                    "4 to print Node List, 5 to end program.");
            int in = inputInt.nextInt();

            switch (in) {
                case 1:
                    System.out.println("Insert element:");
                    String text = inputString.nextLine();                       //input läggs i "text" av typ String
                    test.enqueue(text);                                         //lägg "text" i en nod
                    System.out.println("Node list: " + test.convertToString()); //printa nuvarande innehåll i nodlista
                    break;

                case 2:
                    test.dequeue();                                             //kallad metod tar bort första noden
                    System.out.println("Node list: " + test.convertToString());
                    break;

                case 3:
                    ListIterator <String> x = test.iterator();                  //nytt objekt av typ ListIterator
                    boolean j = true;
                    int a;
                    //ny while loop låter oss testa iterator kontinuerligt
                    while (j) {

                        System.out.println("Type 1 for next, 2 for prev, 3 to leave iterator");
                        a = inputInt.nextInt();

                        if (a == 1)             //iterera bakåt i kön
                            x.next();
                        else if (a == 2)        //iterera framåt i kön
                            x.previous();

                        else if (a == 3)
                            j = false;          //avbryt while loop

                       }
                    break;

                case 4:
                    System.out.println("Node list: " + test.convertToString());
                    break;
                    
                case 5:
                    i = false;                  //avbryt while loop
                    break;
                }
        }

        System.out.println("End of program!");
    }
}


