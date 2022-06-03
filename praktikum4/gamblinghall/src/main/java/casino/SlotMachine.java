/**
 * @author : Elias Haberl
 * @created : 2022-05-18
 */
/** SlotMachine
 * Abstract Class implementing getRealPayoutRate from GamblingMachine
 * 
 * */
package casino;

import java.util.Scanner;
abstract class SlotMachine implements GamblingMachine {
  /** name of Machine */
  private final String name;
  /** All the money spent playing combined */
  private double revenue;
  /** Profit generated for machine */
  private double profit;
  /** Amount of Games played */
  private int countGames;
  /** Wins */
  private int countWins;

  /**
   * Constructor for SlotMachine
   *
   * @param name String for name of SlotMachine
   */
  public SlotMachine(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name cannot be null nor of length 0");
    }
    this.name = name;
    this.revenue = 0;
    this.countGames = 0;
    this.countWins = 0;
  }

  // public double getRealPayoutRate() {
  // double realRate = 0;
  // this.stake = 1;
  // double[] revenueArray = new double[9];
  // double[] profitArray = new double[9];
  // int[] countGamesArray = new int[9];
  // int[] countWinsArray = new int[9];
  // play 100.000 times for each doubleshot machine
  //
  // for (int i = 0; i < 100000; i++) {
  // for (int j = 0; j < ds_Array.length; j++) {
  // double result = 0;
  // countGamesArray[j]++;
  // result = ds_Array[j].play(stakes);
  // System.out.println(result);
  // revenueArray[j] += stakes;
  // if (result > 0) {
  // countWinsArray[j]++;
  // profitArray[j] -= result;
  // } else {
  // profitArray[j] += stakes;
  // }
  // }
  // }
  // double profitsum = 0;
  // for (int i = 0; i < profitArray.length; i++) {
  // profitsum += profitArray[i];
  // }
  // double revenueSum = 0;
  // for (int i = 0; i < revenueArray.length; i++) {
  // revenueSum += revenueArray[i];
  // }
  // realRate = (revenueSum - profitsum)/this.getCountGames();
  // return realRate;
  // }
  // Getter Methods
  public String getName() {
    return this.name;
  }

  public double getRevenue() {
    return this.revenue;
  }

  public double getProfit() {
    return profit;
  }

  // public double getProfit() {
  // return this.profit;
  // }

  /**
   * Getter for countGames
   * @return Games played with this machine
  */
  public int getCountGames() {
    return this.countGames;
  }

  /**
   * Getter for countWins
   * @return Wins with this machine
  */
  public int getCountWins() {
    return this.countWins;
  }


  /**
   * Method to add funds to current game
   *
   * @param cash Accepts double values greater than 0
   */
  public void payIn(double cash) {
    if (cash <= 0) {
      throw new IllegalArgumentException("Cannot pay in less than or 0");
    }
    this.revenue += cash;
    return;
  }
  /**
   * Method to add pay out funds from current game
   *
   * @param cash Accepts double values greater than 0
   */
  public void payOut(double cash) {
    if (cash <= 0) {
      throw new IllegalArgumentException("Cannot pay out less than or 0");
    }
    this.revenue -= cash;
    return;
  }

  /**
   * Dummy play method to be overridden
   * @param stake Stake for machine
   * @return Dummy 1.0
  */
  public double play(double stake) {
    return 1.0;
  }

  /**
   * Compares 2 SlotMachines 
   * @param slot The slotmachine to be compared to
   * @return returns true if equal
  */
  public boolean equals(SlotMachine slot) {
    boolean isEqual = true;
    if (this.name != slot.getName()) {
      isEqual = false;
    }
    if (this.revenue != slot.getRevenue()) {
      isEqual = false;
    }
    if (this.profit != slot.getProfit()) {
      isEqual = false;
    }
    if (this.countGames != slot.getCountGames()) {
      isEqual = false;
    }
    if (this.countWins != slot.getCountWins()) {
      isEqual = false;
    }
    return isEqual;
  }

  
  /**
   * Returns name of Machine
   * @return Name of Machine
   * */
  public String toString() {
    return this.name;
  }

  /**
   * Hashes machine Object with Name and Number
   * @param slot The Machine to be hashed
   * @return returns hash
  */
  public int hashCode(SlotMachine slot) {
    return 666 * name.hashCode();
  }
}
