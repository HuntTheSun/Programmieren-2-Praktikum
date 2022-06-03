/**
 * @author : Elias Haberl
 * @created : 2022-05-19
 */
package casino;
/**
 * enum for Types of Roulette games
 * contains game modes, with descrString and payOut Rates
 * */
public enum RouletteGameType {
  NUMBER("Plein", 36),
  RED("Rouge", 2),
  BLACK("Noir", 2),
  EVEN("Pair", 2),
  ODD("Impair", 2),
  LOW("Manque", 2),
  HIGH("Passe", 2),
  P12("Premiere douzaine", 3),
  M12("Moyenne douzaine", 3),
  D12("Derniere douzaine", 3);
  private final String descrString;
  private final int payOutInt;

  private int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
  private int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};

  RouletteGameType(String descrString, int payOutInt) {
    this.descrString = descrString;
    this.payOutInt = payOutInt;
  }

  public int getPayOutInt() {
    return payOutInt;
  }

  public String getDescrString() {
    return descrString;
  }

  public final int[] getRedNumbers() {
    return redNumbers;
  }

  public final int[] getBlackNumbers() {
    return blackNumbers;
  }
}
