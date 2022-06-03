/**
 * @author : Elias Haberl
 * @created : 2022-05-18
 */
package casino;
/** DoubleShot */
public class DoubleShot extends SlotMachine {
  private final int stake;
  private double jackpot;
  private int countJackpot;
  private double profit;
  private double revenue;

  /**
   * Constructor for DoubleShot
   *
   * @param name String for name of DoubleShot
   * @param stake The stake, a whole number between 1 and 10 that sets the amount spent per play
   */
  public DoubleShot(String name, int stake) {
    super(name);
    if (stake < 1 || stake > 10) {
      throw new IllegalArgumentException("Stake must be a whole number between 1 and 10");
    }
    this.stake = stake;
  }
  /**
   * Constructor for DoubleShot
   *
   * @param name String for name of DoubleShot
   */
  public DoubleShot(String name) {
    super(name);
    this.stake = 1;
  }

  public int getStake() {
    return stake;
  }

  public double getJackpot() {
    return jackpot;
  }

  public int getCountJackpot() {
    return countJackpot;
  }

  public double getRealPayOutRate() {
    double rPR = (revenue - profit) / revenue;
    return rPR;
  }

  // COMMENTED BECAUSE STUPID CODE
  // public double getRealPayoutRate() {
  // double realRate = 0;
  // double stakes = this.stake;
  // double revenue = 0;
  // double profit = 0;
  // double countGames = 0;
  //
  // double countWins = 0;
  //
  // // play 100.000 times for each doubleshot machine
  //
  // for (int i = 0; i < 100000; i++) {
  // double result = 0;
  // countGames++;
  // result = this.play(stakes);
  // System.out.println(result);
  // revenue += stakes;
  // if (result > 0) {
  // countWins++;
  // profit -= result;
  // } else {
  // profit += stakes;
  // }
  // }
  // realRate = (revenue - profit)/this.getCountGames();
  // return realRate;
  // }

  //
  /**
   * Method Doubleshot.play, contains logic for the game for the machine DoubleShot
   *
   * @return returns the resulting balance change of the play
   * @param stake The stake with which the game is played, must be the same as stake set by
   *     initialization
   */
  public double play(double stake) {
    // checks if the passed stake is the same as the stake of the DoubleShot instance
    if (this.stake != stake) {
      throw new IllegalArgumentException(
          "Stake passed to DoubleShot.play must be the same stake as in this.stake");
    }
    revenue += stake;  
    // pays the 10% into the jackpot
    this.jackpot += 0.1 * stake;
    double result = 2.0;
    double spinresult = Math.random();
    // checks if the jackpot has been hit (0.1% chance)
    if (spinresult <= 0.001) {
      result = this.jackpot;
      this.jackpot = 0;
      this.countJackpot++;
    }
    // checks if doubleShot resulted in no win
    else if (spinresult <= 0.55) {
      result = 0.0;
    }
    profit += stake - result;
    return result * stake;
  }

  public double getProfit() {
      return profit;
  }

  public double getRevenue() {
      return revenue;
  } 
}
