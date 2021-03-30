package Uppgift4;
import java.util.Iterator;

public class programNode {

    public static void main (String [] args){

        System.out.println("Test");
        //scanner låter oss ta inmatning från keyboarden.
        java.util.Scanner inputInt = new java.util.Scanner(System.in);
        java.util.Scanner inputString = new java.util.Scanner(System.in);
        boolean i = true;

        //skapar ett objekt av typen nodeList med referens x
        nodeList <String> x = new nodeList<>();

        /*While loopen körs till variabel i ändras till false. Loopen gör att vi kan kontinuerligt
         lägga till/ta bort noder och testa implementering utan att starta om program*/
        while (i) {

            System.out.println("\nType 1 to create node, 2 add front, 3 add back, " +
                    "4 remove front, 5 remove back, 6 iterator ,7 end program");
            int in = inputInt.nextInt();

            //cases för switch väljs mha "in" via .nextInt (inmatad heltal av användaren)
            switch (in) {
                case 1:
                    System.out.println("Input element");
                    String text = inputString.nextLine();           //inmatning läggs i "text" av typ String
                    x.createFirstNode(text);                        //lägger till "text" i en första nod
                    System.out.println("Content: " + x.convertToString()); //printar nuvarande innehåll i nodlista
                                                                            //används ett flertal ggr nedan!
                    break;
                case 2:
                    System.out.println("Input element");
                    String text2 = inputString.nextLine();          //inmatning läggs i "text2" av typ String
                    x.addFront(text2);                              //lägger "text2" i första noden i listan
                    System.out.println("Content: " + x.convertToString());
                    break;
                case 3:
                    System.out.println("Input element");
                    String text3 = inputString.nextLine();          //inmatning läggs i "text3" av typ String
                    x.addBack(text3);                               //lägger "text3" i sista noden i listan
                    System.out.println("Content: " + x.convertToString());
                    break;
                case 4:
                    x.removeFront();                                //kallad metod tar bort första noden i nodlistan
                    System.out.println("Content: " + x.convertToString());
                    break;
                case 5:
                    x.removeBack();                                 //kallad metod tar bort sista noden i nodlistan
                    System.out.println("Content: " + x.convertToString());
                    break;
                case 6:
                    Iterator <String> y = x.iterator();             //skapar objekt av typ Iterator
                    boolean j = true;
                    int a;

                    //while loop låter oss testa iterator kontinuerligt
                    while (j) {

                        System.out.println("Type 1 for next, 2 to leave iterator");
                        a = inputInt.nextInt();

                        if (a == 1)             //hoppa framåt i kön
                            y.next();
                        else if (a == 2)        //avbryter while loop
                            j = false;
                    }
                    break;
                case 7:
                    i = false;          //avbryter while loppen!
                    break;
            }
        }
    }
}
