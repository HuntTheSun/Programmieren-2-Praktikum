/**
 * @author : Elias Haberl
 * @created : 2022-05-19
 */
package casino;

/** ArcadeFun */
public class ArcadeFun extends SlotMachine {
  private final int stake;
  private double revenue = 0;
  private double profit = 0;


  
  /**
   * Constructor for ArcadeFun
   * @param name A Name for the Machine, String
  */
  public ArcadeFun(String name) {
    super(name);
    this.stake = 1;
  }


  /**
   * Constructor for ArcadeFun
   * @param name A Name for the Machine, String
   * @param stake Stake (bet multiplier), Int 1-10
  */
  public ArcadeFun(String name, int stake) {
    super(name);
    if (stake > 10 || stake < 1) {
      throw new IllegalArgumentException("Stake must be 1-10");
    }
    this.stake = stake;
  }

  public double getRealPayOutRate() {
    double profit = this.getCountGames() - this.getCountWins();
    double rPR = (this.getCountGames() - profit) / this.getCountGames();
    return rPR;
  }

  public double play(double stake) {
    if (this.stake != stake) {
      throw new IllegalArgumentException(
          "Stake passed to DoubleShot.play must be the same stake as in this.stake");
    }
    revenue++;
    profit++;
    return 0.0;
  }

  public int getStake() {
    return stake;
  }
   public double getRevenue() {
       return revenue;
   }

   public double getProfit() {
       return profit;
   }
}
