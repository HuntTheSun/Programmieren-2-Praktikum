/**
 * @author : Elias Haberl
 * @created : 2022-04-02
 */
public class RFactor { // class declaration
  public static void main(String[] args) { // standard "main" expression

    double infected = 100; // variable declaration
    double rFactor = 1.1; // variable declaration
    int iterations = 10; // variable declaration

    if (args.length != 3) { // checks if more than 3 parameters are provided
      System.out.printf("Syntax: %n java RFactor $infected $rFactor $iterations %n");
      System.exit(-1); // exits if !3 arguments have been provided
    }

    for (int i = 0; i < args.length; i++) { // checks for each argument, if it matches integer or double format
      if (!(args[i].matches("\\d+(\\.\\d+)?"))) { //checks if argument starts with 1 or more digits, then 0+ dots, followed by 0+ digits
        System.out.printf(
            "Please only enter numbers as parameters, accepted formats: 10, 10.0, 10.0000.... %n");
        System.exit(-1); //exits
      }
    }

    infected = Double.parseDouble(args[0]); // converts String to double and sets value for infected
    rFactor = Double.parseDouble(args[1]); // converts String to double and sets value for rFactor
    iterations = Integer.parseInt(args[2]); // converts String to int and sets value for iterations

    // Starts printing the output
    System.out.printf(
        "Initial:  %.6f %n",
        infected); // prints inital value, formatted to 6 decimal points, with a newline

    for (int i = 1; i <= iterations; i++) { // loops until  specified no. of iterations have passed
      infected = infected * rFactor; // calculates new infected number for the current interation
      System.out.printf(
          "Iteration " + i + ": %.6f %n",
          infected); // prints infected value, formatted to 6 decimal points, with a newline
    }
    return;
  }
}
