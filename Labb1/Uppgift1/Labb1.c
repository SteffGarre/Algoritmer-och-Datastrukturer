//
//  Labb1.c
//  Created by Stefan Garrido on 2020-08-27.
//

#include "Labb1.h"
#include <stdio.h>

//metod kallas rekursivt
void reverse (){
    int tecken;
    
    //om värdet i tecken inte är lika med värde motsvarade "newline", kalla på metod igen.
    if ((tecken = getchar()) != '\n')
        reverse();
    
    /*när vi når base case: "tecken" = '\n', skickar putchar() den nuvarande tecken till stdout (display) och vi hoppar ur metod. Vi går bakåt och börjar att skicka ut alla tecken i tidigare putchar() tills vi når den första inmatade tecken, på detta sätt reversas hela inmatningen! */
    putchar(tecken);
   
}
//metod tar emor en pekare till array samt integer
void reverseCharIteration (int *array, int nrOfChar){
    
    printf("\nCharacters in reverse: \n");
    
    //minska nrOfChar med -1 och printa ut innehål i array bakifrån.
    while (nrOfChar != 0){
        putchar(array[nrOfChar-1]);
        nrOfChar--;
    }
}

int main (void){
    
    //Kallar på rekursiv metod
    printf("\nInput a number av characters! (Recursive) \n");
    reverse();
    
    //Kallar på iterativ metod
    printf("\nInput a number av characters! (Iteration) \n");
    
    int array [20];     //om antal tecken överstiger 20 får vi ett fel
    int input;
    int nrOfChar = 0;
    
    
    /* While loop körs till newline tecken trycks. Getchar returnerar en int som läggs i input, värdet jämförs med motsvarande värde för "newline" */
    while ((input = getchar()) != '\n'){
        array [nrOfChar] = input;              //värdet läggs i array
        nrOfChar++;                            //öka antal tecken med 1
    }
    
    //skicka array och nrOfChar till metod
    reverseCharIteration(array, nrOfChar);
        
    printf("\n\n");
}
