// Programmer: Dylan Canfield
// Class: CS &145
// Date 7-8/**/2022
// Assignment: Letter Inventory
// Take user input and sort alphabetically
// Keep a "letter inventory" of all letters
// implement class with an array of 26 counters
// search for individual letter counts
// catch IllegalExceptions or unexpected input
// **** CODE OF NOTE ****
// try/catch (102) Illegal Exception
// switch/case (132), (165)
// fetch method (101-125) individual letter search
// code is crash resistant


public class LIManager { // manager class for LetterInventory
    public static void main(String[] args) {
        /* For TESTING
        String userInput = "aaabcdefghijklmnopqrstuvwxyz";
        String userInput = "abcdefghijklmn";
        String userInput = "abbccce";
        */

        LetterInventory testLI = new LetterInventory();
        testLI.intro();
        testLI.menu();

        System.out.println("Thanks for playing!");
    } // end of main method
} // end of class LIManager



