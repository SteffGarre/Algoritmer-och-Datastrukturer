package Uppgift2;

//Denna klass har skapats för att göra det lättare att urskilja reverse metoden
// gentemot den iterativa som använder en ADT

public class recursiveReverse {
    //Metod tar emot en sträng och returnerar en sträng.
    String reverseRec (String string){

        /*Base case: då sträng minskar i storlek (pga substring) jämför vi då längd av sträng = 0.
        Då har vi nått vår base case och börjar rekursivt att returnera sträng */
        if (string.length() == 0){
            return "";
        }

        /* Substring skapar en ny sträng från index 1 till slut av "string". Index 0 av "string" sparas.
         Metoden reverseRec kallas på nytt, dock skickas endast substringen vidare. Samma procedur görs där index 0 av
          substring sparas och en ny substring skapas tills man når base case. När metoden returneras rekursivt kommer
          den sist sparade index 0 att returneras tills vi når början igen och en ny omvänd sträng skapas! */
        return reverseRec(string.substring(1)) + string.charAt(0);
    }

}
