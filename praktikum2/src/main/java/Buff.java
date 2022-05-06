/**
 * @author : Elias Haberl
 */

/**
 * A Class for Buffs
 * Attribues: Name, DefenseChange, AttackChange
 * */
public class Buff {
  private final String name; // Name of Buff
  private final int defenseBuff; // Value added to Defense when Buff is active
  private final int attackBuff; // Value added to Attack when Buff is active

  /**
   * Constructor for Buff
   * @param n   Name of Buff
   * @param dB  Defense added
   * @param aB  Attack added
  */
  public Buff(  
      String n,
      int dB,
      int aB) { 
    if (n == null || n.isEmpty()) { // checks if name is null or an empty String
      throw new IllegalArgumentException("Name of Buff cannot be empty, nor null");
    }
    if (dB <= 0 && aB <= 0) { //checks if attack and defense applied are 0 or less, because that would be a nerf, not a buff
      throw new IllegalArgumentException(
          "Values of defenseBuff and attackBuff cannot both be 0 or less");
    }
    this.name = n; //sets value for buff instance  
    this.defenseBuff = dB;
    this.attackBuff = aB;
  }
  /**
   * Getter for Name of Buff
   * @return Name of Buff
  */
  public String getName() { //getter for Name
    return this.name;
  }

  /**
   * Getter for defenseBuff value
   * @return defenseBuff value
  */
  public int getDefenseBuff() { 
    return this.defenseBuff;
  }
  /**
   * Getter for attackBuff value
   * @return attackBuff value
  */
  public int getAttackBuff() { 
    return this.attackBuff;
  }

  public String toString() { //prints Buff in desired String format
    return this.name
        + " "
        + "(D:"
        + Integer.toString(this.defenseBuff)
        + ", A:"
        + Integer.toString(this.attackBuff)
        + ")";
  }

  /**
   * checks if ALL Values of 2 buff instances are equal
   * @param other The buff to be compared to
   * @return     True if the buffs are the same
   */
  public boolean equals(Buff other) { 
    boolean isEqual = false;
    if (other == null) { isEqual = false;}
    else if(this.name == other.name    //checks if other values match
        && this.defenseBuff == other.defenseBuff
        && this.attackBuff == other.attackBuff) {
        isEqual = true; //sets true if matching
    } 
    return isEqual; 
  }
}
