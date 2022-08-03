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

import java.util.Arrays;
import java.util.Scanner;

public class LetterInventory {
    //private int size;
    private static int[] inputArr;

    public static final int ALPHABETCOUNT = 26;
    private char letter;
    private boolean hasInput = false;

    private boolean fetchAgain = true;

    private boolean playAgain = true;

    private final String alphabet = "[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, Y, X, Z]";


    public void intro() { // program introduction
        System.out.println("Welcome to \"Letter Inventory.\"");
        System.out.println("This Java program takes your input,");
        System.out.println("and then provides a total count of");
        System.out.println("each type of letter.\n");
    } // end of intro

    public void menu() { // main menu-User Choices
        Scanner menuConsole= new Scanner(System.in);
        System.out.println();
        System.out.println("********MAIN MENU*********");
        System.out.println("(I)nput letter(s) to count\n(D)isplay letter total(s)\n(Q)uit?");
        System.out.print("==> ");
        String answer = menuConsole.next();
        String answerLower = answer.toLowerCase();
        String singleChar = (answerLower.substring(0, 1));

        do if (singleChar.equals("i")) {
            String counted = dataInput();
            sort(counted);
            hasInput = true;
            menuConsole.nextLine();
            menu();

        } else if (singleChar.equals("d")) {
            viewPanel();
            menu();

        } else if (singleChar.equals("q")) {
            playAgain = false;

        } else {
            menuConsole.nextLine();
            System.out.println("Invalid answer. Please try again.");
            menu();

        }
        while (playAgain); // while true run menu method

    } // end of menu method

    public static String dataInput() { // prompt for user input to be sorted
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter whatever combination of");
        System.out.println("text you would like to have sorted.");
        System.out.println("Anything that is not a letter will");
        System.out.println("not be included in the count.");
        System.out.print("==> ");
        String sort = console.nextLine();
        return sort.replaceAll("\\s", ""); // remove blank spaces

    } // end of dataInput method

    public static void sort(String userInput) { // takes user input and creates
        inputArr = new int[ALPHABETCOUNT]; // an array of letter counts
        userInput = userInput.toLowerCase(); // equalize char values

        for (int i = 0; i < userInput.length(); i++) { // for length of input
            if (Character.isLetter(userInput.charAt(i))) { // only count letters
                inputArr[userInput.charAt(i) - 'a']++; // add count to array index position
            }
        } // end of userInput loop
    } // end of sort method


    // return the count of given character
    // IllegalArgumentException for non-alphabetic letter
    public void fetch() {
        Scanner scan = new Scanner(System.in);
        while (fetchAgain) {
            try {
                System.out.println("What letter would you like to check? ");
                letter = scan.next().charAt(0);
                if (!Character.isLetter(letter))
                    throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid letter.");
                fetch();
            } // end of try/catch IllegalArgumentException

            int letterCount = inputArr[Character.toLowerCase(letter) - 'a'];

            if (letterCount < 1) { // letterCount is less than 1
                System.out.printf("Sorry, I didn't find the letter %c.\n", letter);
                fetchAgain();

            } else {
            System.out.printf("\nI found %d of the letter %c.\n", letterCount, letter);
            fetchAgain(); }
            } // end of while (fetchAgain)
    } // end of fetch method

    public void fetchAgain() { // search for another letter count
        Scanner console = new Scanner(System.in);
        System.out.println("Search Again ?");
        System.out.println("(Y)es or (N)o.");
        String fetchAnswer = console.next();
        String fetchAnswerLower = fetchAnswer.toLowerCase();
        switch (fetchAnswerLower.charAt(0)) {
            case 'y':
                fetch();
                break;

            case 'n':
                fetchAgain = false;
                break;

            default:
                System.out.println("Please enter a valid response.");
                fetchAgain();
                break;}
} // end of fetchAgain

    public String toString() { // display sorted userInput
        String result = "[";
        for (int i = 0; i < ALPHABETCOUNT; i++) {
            for (int j = 0; j < inputArr[i]; j++)
                result += (char) ('a' + i);
        }
        return result + "]";
    } // end of toString

    public void viewPanel() { // menu for display choices
        Scanner vPconsole = new Scanner(System.in);
        System.out.println("Would you like to see :");
        System.out.println("(I)ndividual letter counts.");
        System.out.println("(T)otal letter counts.");
        System.out.println();
        System.out.print("==> ");
        String vPanswer = vPconsole.next();
        String vPAnswerLower = vPanswer.toLowerCase();
        switch (vPAnswerLower.charAt(0)) {
            case 'i':
                if (!hasInput) { // check for input
                    System.out.println("Please Input text before searching.\n");
                    menu();
                    break; }

                else { // fetch single letter count
                    fetchAgain = true;
                    fetch();
                    break; }

            case 't':
                diplayTotal(); // print overall totals
                break;

            default:
                System.out.println("Invalid answer. Please try again.");
                viewPanel();
        } // end of switch
        } // end of viewPanel method

    public void diplayTotal() { // print letter totals
        System.out.println("********************************LETTER TOTALS*********************************");
        System.out.println(alphabet);
        System.out.println(Arrays.toString(inputArr));
        LetterInventory testString = new LetterInventory();
        System.out.println("Sorted User Input " + testString);
        System.out.println("******************************************************************************");

    } // end of displayTotal method
} // end of LetterInventory class
