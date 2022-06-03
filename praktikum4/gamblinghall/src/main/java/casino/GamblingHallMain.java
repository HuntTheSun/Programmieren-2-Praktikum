/**
 * @author : Elias Haberl
 * @created : 2022-05-18
 */
package casino;

import java.util.Scanner;

/** GamblingHallMain */
public class GamblingHallMain {



  /**
   * Main method
   * @param args No arguments used
  */
  public static void main(String[] args) {

    //methods for testing the machines
    boolean testDoubleShot = false;
    boolean testRoulette = false;
    if (testDoubleShot) {
      int stakes = 1;
      DoubleShot[] ds_Array = new DoubleShot[9];
      for (int i = 0; i < ds_Array.length; i++) {
        ds_Array[i] = new DoubleShot(("ds" + i), stakes);
        System.out.printf(ds_Array[i].getName() + "\n");
      }
      System.out.printf("Number of DoubleShot machines: %d \n", ds_Array.length);
      double[] revenueArray = new double[9];
      double[] profitArray = new double[9];
      int[] countGamesArray = new int[9];
      int[] countWinsArray = new int[9];
      // play 100.000 times for each doubleshot machine

      for (int i = 0; i < 100000; i++) {
        for (int j = 0; j < ds_Array.length; j++) {
          double result = 0;
          countGamesArray[j]++;
          result = ds_Array[j].play(stakes);
          System.out.println(result);
          revenueArray[j] += stakes;
          if (result > 0) {
            countWinsArray[j]++;
            profitArray[j] -= result;
          } else {
            profitArray[j] += stakes;
          }
        }
        if (i % 100 == 0) {
          System.out.printf("%d-th iteration \n", i);
        }
      }
      System.out.printf("Printing Games Played per Machine:\n");
      for (int i = 0; i < countGamesArray.length; i++) {
        System.out.printf("Machine%d: %d \n", i, countGamesArray[i]);
      }
      System.out.printf("Printing Games won per Machine:\n");
      for (int i = 0; i < countWinsArray.length; i++) {
        System.out.printf("Machine%d: %d \n", i, countWinsArray[i]);
      }
      System.out.printf("Printing revenue per Machine:\n");
      for (int i = 0; i < revenueArray.length; i++) {
        System.out.printf("Machine%d: %f \n", i, revenueArray[i]);
      }
      System.out.printf("Printing profit per Machine:\n");
      for (int i = 0; i < profitArray.length; i++) {
        System.out.printf("Machine%d: %f \n", i, profitArray[i]);
      }
      System.out.printf("");
      double profitsum = 0;
      for (int i = 0; i < profitArray.length; i++) {
        profitsum += profitArray[i];
      }
      System.out.printf("Average Profit all Machines: %f \n", (profitsum / profitArray.length));
      System.out.printf("Printing jackpots per Machine:\n");
      for (int i = 0; i < ds_Array.length; i++) {
        System.out.printf("Machine%d: %d\n", i, ds_Array[i].getCountJackpot());
      }
      return;
    }

    if (testRoulette) {
      double stakes = 1;
      Roulette[] rouletteArray = new Roulette[10];
      for (int i = 0; i < rouletteArray.length; i++) {
        // creates new Roulette for each in rouletteArray
        rouletteArray[i] = new Roulette("Roulette" + i);
        System.out.printf(rouletteArray[i].getName() + "\n");
        // sets RouletteGameType for each Roulette, luckily, there are 10 Types
        rouletteArray[i].setRouletteGameType(RouletteGameType.values()[i]);
      }
      System.out.printf("Number of Roulette machines: %d \n", rouletteArray.length);
      double[] revenueArray = new double[10];
      double[] profitArray = new double[10];
      int[] countGamesArray = new int[10];
      int[] countWinsArray = new int[10];
      // play 100.000 times for each Roulette machine

      for (int i = 0; i < 10000000; i++) {
        for (int j = 0; j < rouletteArray.length; j++) {
          double result = 0;
          countGamesArray[j]++;
          result = rouletteArray[j].play(stakes);
          // System.out.println(result);
          revenueArray[j] += stakes;
          profitArray[j] += stakes;
          if (result > 0) {
            countWinsArray[j]++;
            profitArray[j] -= result;
          }
        }
        if (i % 100 == 0) {
          System.out.printf("%d-th iteration \n", i);
        }
      }
      System.out.printf("Printing Games Played per Roulette:\n");
      for (int i = 0; i < countGamesArray.length; i++) {
        System.out.printf(
            "Roulette%d_%s: %d \n", i, rouletteArray[i].getRouletteGameType(), countGamesArray[i]);
      }
      System.out.printf("Printing Games won per Roulette:\n");
      for (int i = 0; i < countWinsArray.length; i++) {
        System.out.printf(
            "Roulette%d_%s: %d \n", i, rouletteArray[i].getRouletteGameType(), countWinsArray[i]);
      }
      System.out.printf("Printing revenue per Roulette:\n");
      for (int i = 0; i < revenueArray.length; i++) {
        System.out.printf(
            "Roulette%d_%s: %f \n", i, rouletteArray[i].getRouletteGameType(), revenueArray[i]);
      }
      System.out.printf("Printing profit per Roulette:\n");
      for (int i = 0; i < profitArray.length; i++) {
        System.out.printf(
            "Roulette%d_%s: %f \n", i, rouletteArray[i].getRouletteGameType(), profitArray[i]);
      }
      double profitsum = 0;
      // for (int i = 0; i < profitArray.length; i++) {
      // profitsum += profitArray[i];
      // }
      for (double amnt : profitArray) {
        profitsum += amnt;
      }
      System.out.printf("All Profit all Roulettes: %f \n", profitsum);
      System.out.printf("Average Profit all Roulettes: %f \n", (profitsum / profitArray.length));
      return;
    }

    

    // HERE BEGINS THE REAL INTERACTIVE FUN, NOT TESTING
    //new Scanner for use throughout the runtime
    Scanner activeScanner = new Scanner(System.in);
    //Lets user choose Machine Type by a number in activeScanner
    int chosenMachineTypeNumber = GamblingUI.chooseMachineType(activeScanner);
    //sets default Roulette Type
    RouletteGameType chosenRType = RouletteGameType.BLACK;
    //if Roulette is chosen
    if (chosenMachineTypeNumber == 1){
      //choose Roulette Type
    GamblingUI.chooseRouletteType(activeScanner);
      //creates Roulette activeMachine with given Parameters
    SlotMachine activeMachine = GamblingUI.createActiveMachine(chosenMachineTypeNumber, chosenRType);
    // activeMachine.playInteractive(activeScanner);
    }
    //if not Roulette, execute Constructor for ArcadeFun or DoubleShot
    else {
    SlotMachine activeMachine = GamblingUI.createActiveMachine(chosenMachineTypeNumber);
    }
    activeScanner.close();

  }
}
