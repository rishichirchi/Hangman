import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int flag = 0;

        System.out.println("\nWelcome to the game of Hangman!\n");
        System.out.println("Here is the list of all the word that you can use: \n");
        System.out.println(Arrays.toString(words));


        System.out.println("\nThis is your introductory Gallow:\n"+gallows[0]);


        String target = randomWord(words);
        // System.out.println(target);

        char guess;
        
        char[] placeholder = new char[target.length()];

        for(int i = 0; i < target.length(); i++){
            placeholder[i] = '_';
        }
        char[] missed = new char[target.length()];

        for(int i = 0; i < target.length(); i++){

            printPlaceholder(target, placeholder);

            System.out.print("\nMisses: ");
                printMisses(missed);

            System.out.print("\nGuess: ");
            guess = scan.next().charAt(0);

            if(checkGuess(target, guess) == 1){
                updatePlaceholders(guess, placeholder, target);
                System.out.print("\n\n");
                 if(i == 0){
                  System.out.print(gallows[i]);
                }
                else{
                    i--;
                    System.out.print(gallows[i]);
                }

            }
            if(checkGuess(target, guess) == 0){   
                missed[i] =  guess;   
                System.out.println(gallows[i+1]);

            }

            if(Arrays.equals(placeholder, target.toCharArray())){
                flag = 1;
                break;
            }
               
        }

        if(flag == 1){
            printPlaceholder(target, placeholder);
            System.out.println("\nWell Done!! You win!!!");
        }
        else{
            System.out.print(gallows[6]);
            System.out.println("Word: "+ target);
            System.out.println("\n\nRIP");
        }
    }

    public static String randomWord(String[] words){
        int number = (int) (Math.random() * (63) + 1);
        String target = words[number];
        return target;
    }


    public static void printPlaceholder(String target, char[] placeholder){
        System.out.print("\nWord: ");
        for(int i = 0; i < target.length(); i++){
            System.out.print(placeholder[i]);
            System.out.print(" ");
        }
    }


    public static int checkGuess(String target, char guess){
        char[] ch = new char[target.length()]; 
        int flag = 0;

        for(int j = 0; j < ch.length; j++){
            ch[j] = target.charAt(j);
        }

        for(int j = 0; j < ch.length; j++){
            if(guess == ch[j]){
                flag = 1;
            }
        }
        if(flag == 1){
            return 1;
        }
       return 0;
    }



    public static void printMisses(char[] missed){    
        for (int i = 0; i < missed.length; i++) {
            System.out.print(missed[i]);
        }
    }

    public static void updatePlaceholders(char guess, char[] placeholder, String target){
        for(int j = 0; j < target.length(); j++){
            if(target.charAt(j) == guess ){
                placeholder[j] = guess;
            }
        }
    }

}





