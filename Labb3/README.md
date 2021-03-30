# Lab: Searching

### Programming assignments for grade E:
##### 1. Write a simple filter to clean a text, i.e. to remove all characters that are not alphabetic, blank or newline - replacing every such character by a blank to keep the number of characters constant to the original text. Hint: this is easy to do in C using the "isalpha()" function (to find out more about it on a unix/linux system type: man isalpha as a command to the shell)

##### 2. Use the first N (N in the order of hundred words) words from the text to compare the running times of the ordered array ST (also known as binary search symbol table, see algorithm 3.2 in the book (obs not chapter 3.2)) to the Binary Search Tree algorithm (Algorithm 3.3 in the book (obs not chapter 3.3)) (you need only implement the basic operations to put and get keys to/from the ST) Use the FrequencyCounter from page 372 as test program (you may need to change how you read the words if you do not use the libraries from Sedgewick&Wayne). Show tables or graphs of your measurements.

##### 3. Write a program that shows how evenly the built-in hashcode() function for strings in Java distributes the hashcodes for the words found in the text. (Hint it may be hard to use the hashcodes directly...)

##### 4. Write an "index"-program which allows the user to ask questions "on which positions in the text (i.e. the number of characters from the beginning) you find the word X". The program should list the position of all occurrences of X as answer to a query. In this assignment you may use the Java library (built-in) lists. Questions to the index should be answered in time less or equal to O(log(N)) where N is the number of keys.
