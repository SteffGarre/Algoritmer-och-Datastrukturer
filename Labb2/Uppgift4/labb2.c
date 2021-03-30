 
//
//  Created by Stefan Garrido on 2020-09-12.
//

#include "labb2.h"
#include <stdio.h>
#include <stdlib.h>



/*Egen kod, metod sort går igenom en array och flyttar om så att negativa tal hamnar i början
 av array. Metod använder sig av två variabler som startar på index 0: i och j.
Variabel "i" flyttas fram 1 steg efter varje loop iteration och kontrollerar om element
 "array[i]" är negativ. Variabel j flyttas fram om element "array[j]" är negativ eller om villkor
 (array [i] < 0) && (array[j] >= 0) uppfylls. På så sätt utförs det endast swaps när j pekar mot ett positiv heltal och antal swaps minimeras.
 Algortimen utförs linjärt och antal swaps är i bästa fall noll och i värsta fall n-1.
 */


void sort (int array [], int size){

    int j = 0;
    int swaps = 0;
    
    for(int i = 0; i < size; i++){
        
        //en swap utförs om element i är negativ OCH om element j är postiv
        if((array [i] < 0) && (array[j] >= 0)){
            
            //swap mellan index i och j
            int temp = array [j];
            array [j] = array [i];
            array [i] = temp;
            j++;
            swaps++;
            continue;       //skippar nuvarande iteration och går till nästa iteration i for loop
        }
        
        if(array[j] < 0)
            j++;
          
    }
    
    printf("\nswaps: %d", swaps);
}


int main (void){
    
    //färdiga arrays med olika varianter av positiva och negativa heltal
    
    //int array [] = {-11, 3, 2, 5, 7, 9, 7, 8, 0, 11};
    //int array [] = {11, -3, -2, -5, -7, -9, -7, -8, -2, -11};
    int array [] = {0, -3, -2, 5, 7, 9, -7, -8, 0, -11};
    
    //antal element i en array (size) fås genom att dela antal bytes av array
    //med antal bytes av en integer
    int size = sizeof(array)/sizeof(array[0]);
    
    //metod sort kallas
    sort(array, size);
    
    //printar ut sorterad array
    int y = 0;
    printf("\n{");
    while(y < size){
        printf(" %d ", array[y]);
        y++;
    }
    printf("}\n\n");
    
    
}
