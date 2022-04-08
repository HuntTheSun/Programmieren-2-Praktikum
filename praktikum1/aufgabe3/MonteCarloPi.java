/**
 * @author : Elias Haberl
 * @created : 2022-04-07
**/

public class MonteCarloPi{
  public static void main(String args[]){
  double diffMagnitude = Math.pow(10, -5); //calculates the magnitude of difference, so it isnt calculated each time in while loop
  double difference = 1;  //declares and initializes the variable difference
  int inSquare = 0; //declares and initializes the variable inSquare 
  int inCircle = 0; //declares and initializes the variable inCircle
  double approxPi =  0; //declares and initializes the variable approxPi
  double pi = Math.PI; //declares and initializes the variable pi so it isnt calculated each time in while loop
  int iterations =  0; //declares and initializes the variable iterations
  double x = 0; //declares and initializes the variable x for the x "coordinate"
  double y = 0;  //declares and initializes the variable y for the y "coordinate" 

  while (Math.abs(difference)>diffMagnitude){ //while the absolute difference between difference (approxPi-pi) is bigger than diffMagnitude (start value=1)
    x = Math.random(); //sets x as random number between 0 and 1
    y = Math.random(); //sets y as random number between 0 and 1
    inSquare++; 
    iterations++; 
    if (Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))<=1){ //calculates if the coordinates are in the Circle, according to the formula in the task
      inCircle++;
    }
    approxPi = 4*((double)inCircle/inSquare); //sets approxPi according to the calculated values of inCirlcle and inSquare
    difference = approxPi-pi;  //recalculates differnce for the evaluation of the while loop
    System.out.printf("%f%n", approxPi); //prints the current estimation of pi
  }
  System.out.printf("Iteration %d:  %f%n", iterations, approxPi); //prints the number of iterations run and the appropiately precise approximation of pi
  return;
  }
} 
