package Uppgift5;


public class programGenQueue {

    public static void main (String [] args){

        System.out.println("Test");
        //Scanner gör det möjligt att få input från system.in, dvs keyboarden
        java.util.Scanner inputInt = new java.util.Scanner(System.in);
        java.util.Scanner inputString = new java.util.Scanner(System.in);
        boolean i = true;

        //skapa ett nytt objekt av typen genQueue
        genQueue queue = new genQueue();

        /*while loopen körs till variabel i ändras till false.While loopen gör att vi kan testa lägga
        till/ta bord noder kontiunerligt utan att behöva starta om program */
        while (i) {

            System.out.println("\nType 1 to add node, 2 remove node, 3 end program");
            int in = inputInt.nextInt();        //variabeln "in" låter mig välja case i switch

            switch (in) {
                case 1:
                    System.out.println("Input element");
                    String text = inputString.nextLine();       //inmatning sparas i "text" av typ String
                    queue.addNode(text);                        //lägg element "text" i en nod mha metod addNode
                    System.out.println("Content: " + queue.convertToString()); //printa nuvarade nodlista
                    break;

                case 2:
                    System.out.println("Input index you wish to remove");
                    int counter = inputInt.nextInt();           /*inmatninng sparas i variablen "counter",
                                                                motsvarar önskad index för borttagning*/
                    queue.removeNode(counter);                  //skicka int counter till metod removeNode
                    System.out.println("Content: " + queue.convertToString());  //printa nuvarade nodlista
                    break;
                case 3:
                    i = false;      //öndrar variabel i till false och avslutar while loop
                    break;

            }
        }
    }
}
