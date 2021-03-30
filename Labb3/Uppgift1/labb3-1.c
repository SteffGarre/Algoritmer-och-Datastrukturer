//
//  labb3-1.c
//  
//
//  Created by Stefan Garrido on 2020-09-23.
// // this code is written by Stefan GArrido & Ali Shawhali

#include "labb3-1.h"
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>

int main (void){
    
    //skapa 2 pekare av typen FILE
    FILE *ptr1;
    FILE *ptr2;
    
    //vi vill skriva (w) till "newtext" och läsa ur (r) "thetext", om "newtext" inte finns så skapas en textfil.
    ptr1 = fopen("newtext.txt", "w");
    ptr2 = fopen("randomtext.txt", "r");
    
    //Om vi inte kan skapa en ny fil "newtext" eller läsa ur "thetext" - ge error!
    if(ptr1 == NULL || ptr2 == NULL){
        printf("Error! file doesn't exist\n");
        return -1;
    }
        
    
    char ch;
    
    //loopen körs till vi når end of file
    while( (ch = fgetc(ptr2)) != EOF){
        
        //om tecken är alfabetikst eller newline, lägg denna i "newtext"
        if ((isalpha(ch) != 0 || ch == '\n')){
            fputc(ch,ptr1);
        }
        
        //om tecken är mellanslag (32 i ASCII) lägg i "newtext"
        else{
            fputc(32,ptr1);
        }
    }
    
    //stäng läsning av filer
     fclose(ptr1);
     fclose(ptr2);
    
     return 0;
    

}
