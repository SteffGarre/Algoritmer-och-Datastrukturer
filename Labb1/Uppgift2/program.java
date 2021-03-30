package Uppgift2;

public class program {

    public static void main(String[] args) {

        System.out.println("TEST");
        //Scanner funktion låter oss ta input från system.in (dvs keyboard)
        java.util.Scanner inputInt = new java.util.Scanner(System.in);
        java.util.Scanner inputString = new java.util.Scanner(System.in);

        //Switch funk. används för att välja mellan rekursiv eller iterativ metod mha .nextInt
        System.out.println("\nType 1 for recursive, 2 for iterative");
        int in = inputInt.nextInt();

        switch (in) {
            case 1:
                System.out.println("Insert a serie of characters!");
                String serieOfChar = inputString.nextLine();             /*serieOfChar blir vår sträng som knappas
                                                                            in via system.in */
                recursiveReverse x = new recursiveReverse();            /*skapar nytt objekt av typ recursiveReverse
                                                                        Obs! nytt objekt behövs egentligen inte, detta
                                                                        gjordes för att separera metoden från den
                                                                        iterativa versionen */
                String string = x.reverseRec(serieOfChar);              //kallar på metoden reverseRec

                System.out.println("Content reversed (Recursive): ");
                int b= 0;
                StringBuilder result1 = new StringBuilder();            /*SB används för att utforma den omvända strängens
                                                                        enligt format: [ + tecken + ] */
                while (b < string.length()) {
                    result1.append("[").append(string.charAt(b)).append("]");
                    b++;
                }
                System.out.println(result1.toString());                 //Omvandla SB till en sträng och printas.
                break;
            case 2:
                stack stack = new stack();                              //Nytt objekt av typen stack
                System.out.println("Insert a serie of characters!");
                String serieOfChar2 = inputString.nextLine();           /*serieOfChar2 blir vår sträng som knappas
                                                                         in via system.in */

                int a = 0;
                while (a < serieOfChar2.length()){                       /*While loopen gör att vi kan pusha tecken
                                                                        enligt index på serieOfChar2, och lägga varje
                                                                        tecken i sträng serieOfChar2 i en nod*/

                    stack.push(serieOfChar2.charAt(a));
                    a++;
                }

                System.out.println("Content reversed (Iterative): ");
                StringBuilder result2 = new StringBuilder();            //SB används för att få format: [ + tecken + ]
                while (!stack.isEmpty()){                               /*While loop utförs så länge nod listan i klassen
                                                                        stack inte är tom. Metod pop poppar tecknet i den
                                                                        första noden i listan. */

                    result2.append("[").append(stack.pop()).append("]");
                }
                System.out.println(result2.toString());                 //Omvandla SB till en sträng och printas.
        }
        System.out.println("End of program!");
    }
}


