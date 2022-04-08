/**
 * @author : Elias Haberl
 * @created : 2022-04-07
**/


public class Wordle {
  public static void main(String args[]){
    String solution = "TASSE"; //declares and initializes the solution word
    int guessesLeft = 6; //declares and initializes the variable for counting how many guesses are left
    String userInput; //declares the string for userInput
    java.util.Scanner userInputScanner = new java.util.Scanner(System.in); //creates new Scanner object for input
    boolean correct = false; //declares and initializes the variable used to check if the entered word is matching perfectly


      for (int i = 0; i<=5; i++){ ///iterates through String and sets the solution_tips array appropriately
        System.out.printf("%nGuess the secret word! You have %d guesses! %n", guessesLeft); //prompts user for word entry
        userInput = new java.util.Scanner(System.in).nextLine();		//sets the userInput String as the user-entered word

        if (userInput.length()!=5){System.out.println("Please enter a word with a length of 5"); i--;}  //checks if the userInput is 5 characters long
        else {
        for (int j=0; j<5; j++){ //loops 5 times (1 for each char in input)
          char c = Character.toUpperCase(userInput.charAt(j)); //converts char at position i to upper case
          
          if (userInput.equals(solution)) {System.out.printf("You guessed right! It took you %d tries%n", 6-guessesLeft); correct = true; break;} //sets correct to true (for right exit statement) and aborts for loop
          if (c == solution.charAt(j)) System.out.print(c); //prints the char in the current position if the chars from the solution and input match
          else if (solution.contains("" + c)) System.out.print("?"); //prints ? if the input at the current position is contained in the solution
          else System.out.print("!"); //prints ! when the input char isnt found in the solution
        }
        if(correct) break; //aborts the for loop for String entry and comparison if the correct word has already been guessed
        else guessesLeft--; //subtracts 1 guess, if the correct word has not been entered
        }
      }
  
  if(guessesLeft<1) System.out.printf("%nSorry, all guesses gone! Try again next time!%n"); //promtps message if all guesses have been exhausted
  return;
  }
}

