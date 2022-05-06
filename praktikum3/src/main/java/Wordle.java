import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Wordle {

  // TODO: implement this method!
  /**
   * A Function that reads words from a list and filters it for length, heuristic, type and singularity and formats it to the desired output
   * @param minFreq   The desired minimal heuristic of a word
   * @return          Returns a String Array with valid words
  */
  private static String[] getWords(int minFreq){

    String words = readAllLinesFromDict();
    
    //creates String Array with 1 index per line
    String splitLines[] = words.split("\\n");

    StringBuilder sb1 = new StringBuilder();

    for (int i = 0; i < splitLines.length; i++) {
      boolean wordFits=true;
      //creates String Array where word, type and heuristic of 1 line are stored as Strings
      String localWordTypeHeuristic[] = splitLines[i].split("\\t");
      //The follwing are checks to see if the word is fitting
      //checks if worde Type is "NoC"
      if(!localWordTypeHeuristic[1].equals("NoC")) {wordFits = false;}
      
      //checks if word is 5 chars long
      if (wordFits){
        if(localWordTypeHeuristic[0].length()!=5){
          wordFits = false;
        }
      }

      //checks if word contains invalid characters
      if(wordFits){
        for (int j = 0; j < localWordTypeHeuristic[0].length(); j++) {
          //checks if the current char is not a letter
          if(!Character.isLetter(localWordTypeHeuristic[0].charAt(j))) {
            wordFits = false; 
          }
        }
      }

      //checks if heuristic of word is lower than minFreq
      if(wordFits){
        if(Integer.parseInt(localWordTypeHeuristic[2]) < minFreq){
          wordFits = false; 
        }
      }

      //checks if word ends with s
      if (wordFits){
        if((localWordTypeHeuristic[0].charAt(localWordTypeHeuristic.length-1)) == 's'){
          wordFits = false;
        }
      }
      
      //if the word passed the tests, convert to UpperCase and append it to the StringBuilder

      if(wordFits){
        sb1.append(localWordTypeHeuristic[0].toUpperCase());
        sb1.append(":");
      }
      //end of for loop after all words have been processed
    }

    String solutionStringWithColons = sb1.toString();
    String solutionStringArrayWithoutColons[] = solutionStringWithColons.split(":");


    // TODO
    //  - read line-by-line
    //  - skip if ...
    //    - word is not a noun (NoC)
    //    - word contains a non-alpha character
    //    - frequency is below minFreq
    //    - last letter is 's'
    //    - if length != 5
    //  - convert to upper case
    //  - append to StringBuilder (with separator)
    //  - split result to array

    return solutionStringArrayWithoutColons;
    // return new String[] {"PAPER", "METAL", "DELAY"};

  }

  public static void main(String[] args) {
    String[] candidates = getWords(15);
    playWordle(candidates);
    // for (int i = 0; i < candidates.length; i++) {
      // System.out.println(candidates[i]);
    // }
    return;
  }

  private static String readAllLinesFromDict(){
    try {
      return Files.readString(Path.of("/home/man/w10_vm/Google Drive/FH/2022ss/programmieren2/praktikum/solutions/praktikum3/src/main/java/words.txt"));
    } catch (IOException e){
      e.printStackTrace();
      throw new UncheckedIOException(e);
    }

  }


  private static void playWordle(String[] words){
    Scanner scanner = new Scanner(System.in);
    boolean finished = false;
    int tries = 0;

    String secret = words[(new Random()).nextInt(words.length)];
    java.util.Set<String> set = java.util.Set.of(words);

    System.out.printf("Number of words in dictionary: %d%n", words.length);
    System.out.println("Guess the secret word! You have 6 guesses!");

    while (!finished){

      String input = scanner.nextLine();

      if (input.length() != 5){
        System.out.println("Please enter exactly 5 characters");
        continue;
      }

      if (!set.contains(input.toUpperCase())){
        System.out.println("Word is not in dictionary!");
        continue;
      }


      int matches = 0;


      for (int i = 0; i < 5; i++){

        char inputChar = Character.toUpperCase(input.charAt(i));

        if (inputChar == secret.charAt(i)){
          System.out.print(inputChar);
          matches++;
        } else if (secret.indexOf(inputChar) != -1){
          System.out.print("?");
        } else {
          System.out.print("!");
        }
      }

      System.out.println();

      if (matches == 5){
        System.out.println("You guessed right!");
        finished = true;
      }

      tries++;
      
      if (tries == 6){
        System.out.println("No tries left!");
        System.out.printf("The word was: %s", secret);
        finished = true;
      }

    }

  }

  
}
