/**
 * @author : Elias Haberl
 * @created : 2022-05-19
 */
package casino;

import java.util.Random;
import java.util.Scanner;

/** Roulette 
 * @see SlotMachine for variable Description
 * */

public class Roulette extends SlotMachine {
  private RouletteGameType rouletteGameType;
  private int betNumber;
  private int countGames;
  private int countWins;
  private double revenue;
  private double profit;

  /**
   * Constructor for Roulette
   * @param name Name of roulette
  */
  public Roulette(String name) {
    super(name);
    this.rouletteGameType = RouletteGameType.BLACK;
  }

  /**
   * Constructor for Roulette
   * @param name Name of roulette
   * @param rouletteGameType Type of RouletteGame from enum RouletteGameType
  */
  public Roulette(String name, RouletteGameType rouletteGameType) {
    super(name);
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException(
          "String name for creating instance of Roulette cannot be null or empty");
    }
    if (rouletteGameType == null) {
      throw new IllegalArgumentException("rouletteGameType cannot be null");
    }
    if (rouletteGameType == RouletteGameType.NUMBER) {
      throw new IllegalArgumentException("rouletteGameType cannot be NUMBER");
    }
    this.rouletteGameType = rouletteGameType;
  }

  /**
   * Constructor for Roulette
   * @param name Name of RouletteMachine
   * @param betNumber Sets current betNumber for Roulette game (only for 1st gametype needed)
  */
  public Roulette(String name, int betNumber) {
    super(name);
    if (betNumber > 36 || betNumber < 0) {
      throw new IllegalArgumentException("betNumber must be between 0 und 36");
    }
    this.betNumber = betNumber;
    this.rouletteGameType = RouletteGameType.NUMBER;
  }

  public int getBetNumber() {
    return betNumber;
  }

  public RouletteGameType getRouletteGameType() {
    return rouletteGameType;
  }

  /**
   * sets Betnumber
   * @param betNumber 0-36 
  */
  public void setBetNumber(int betNumber) {
    if (betNumber > 36 || betNumber < 0) {
      throw new IllegalArgumentException("betNumber must be between 0 und 36");
    }
    this.betNumber = betNumber;
  }

  /**
   * Calculates ProfitRate
   * @return Rate in which Machine makes profit
   * */
  public double getRealPayOutRate() {
    double rPR = (revenue - profit) / revenue;
    return rPR;
  }


  /**
   * Sets Type of Roulette Game
   * @param rouletteGameType RouletteGameType.$GAMETYPE, 12 values allowed, look em up
   * @see rouletteGameType
  */
  public void setRouletteGameType(RouletteGameType rouletteGameType) {
    if (rouletteGameType == null) {
      throw new IllegalArgumentException("rouletteGameType cannot be null");
    }
    this.rouletteGameType = rouletteGameType;
  }

  /**
   * plays Machine
   * @param stake Stake for the play, 1-10
   * */
  public double play(double stake) {
    if(stake>10 || stake < 1){
      throw new IllegalArgumentException("Stake must be between 1 and 10");
    }
    this.countGames++;
    double result = 0.0;
    Random rand = new Random();
    // creates value 0-36, simulates Roulette spinning
    int value = rand.nextInt(37);
    switch (this.rouletteGameType) {
      case NUMBER:
        // if player bet on the right value, return winAmount
        if (this.betNumber == value) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case RED:
        if (contains(this.rouletteGameType.getRedNumbers(), value)) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case BLACK:
        if (contains(this.rouletteGameType.getBlackNumbers(), value)) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case EVEN:
        if (value % 2 == 0 && value != 0) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case ODD:
        if (value % 2 != 0) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case LOW:
        if (value >= 1 && value <= 18) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case HIGH:
        if (value >= 19 && value <= 36) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case P12:
        if (value >= 1 && value <= 12) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case M12:
        if (value >= 13 && value <= 24) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;
      case D12:
        if (value >= 25 && value <= 36) {
          result = this.rouletteGameType.getPayOutInt() * stake;
        }
        break;

      default:
        throw new IllegalStateException("The machine you play on must have a gametype");
    }
    if(result!=0.0){
      countWins++; 
    }
    profit += stake - result;
    revenue += stake;
    return result;
  }

  public double getProfit() {
      return profit;
  }

  public double getRevenue() {
      return revenue;
  } 

  /**
   * Check if value is in array
   * @param array The array
   * @param value The value
   * @return Return if int is in array
  */
  public boolean contains(final int[] array, final int value) {
    boolean containsBoolean = false;
    for (int i : array) {
      if (value == i) {
        containsBoolean = true;
      }
    }
    return containsBoolean;
  }


  public void printRouletteInterface(Roulette r){
    switch (r.getRouletteGameType()) {
      case NUMBER:
        // GamblingUI.printRouletteInterfaceNUMBER(r);
        break;

      default:
        break;
    }
  }

  /**
   * For Later
   * @param activeScanner Scanner to be used
  */
}
