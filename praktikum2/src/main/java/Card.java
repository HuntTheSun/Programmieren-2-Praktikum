/**
 * @author : Elias Haberl
 */


public class Card {

  // Declares variables for card instance
  private String name;
  private int baseDefense;
  private int baseAttack;
  private Category category;
  private int health;
  private Buff buff;

  /**
   * Constructor for Card
   * @param n Name of Card //@TODO wertebereiche
   * @param bD Base Defense
   * @param bA Base Attack
   * @param c Category
   * @param h Health
  */
  public Card(String n, int bD, int bA, Category c, int h) {
    // checks if Name-String is null or empty
    if (n == null || n.isEmpty()) {
      throw new IllegalArgumentException("Name of Card cannot be empty, nor null");
    }
    // checks if baseAttack is lower than 0
    if (bA < 0) {
      throw new IllegalArgumentException("Base Attack cannot be lower than 0");
    }
    // checks if baseDefense is lower than 0
    if (bD < 0) {
      throw new IllegalArgumentException("Base Defense cannot be lower than 0");
    }
    // checks if Category is null 
    if (c == null) {
      throw new IllegalArgumentException("Category must be set/cannot be NULL");
    }
    // checks if health is lower than or 0
    if (h <= 0) {
      throw new IllegalArgumentException("Health cannot be lower than nor 0");
    }
    // sets variable values for created instance of Card
    this.name = n;
    this.baseAttack = bA;
    this.baseDefense = bD;
    this.category = c;
    this.health = h;
  }

  /**
   * Getter for CardName
   * @return Name of Card
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter for BaseAttack
   * @return BaseAttack of Card
   */
  public int getBaseAttack() {
    return this.baseAttack;
  }

  /**
   * Getter for BaseDefense
   * @return BaseDefense of Card
  */
  public int getBaseDefense() {
    return this.baseDefense;
  }

  /**
   * Getter for Buff
   * @return Active Buff of Card
  */
  public Buff getBuff() {
    return this.buff;
  }

  /**
   * Setter for Buff
   * @param b Buff to be applied to Card
  */
  public void setBuff(Buff b) {
    this.buff = b;
  }

  /**
   *  checks if Card is alive 
   * @return True if alive
  */
  public boolean isAlive() {
    //checks if Card has name (workaround for exists) 
    if (this.name == null) {
      throw new IllegalArgumentException("The card you checked if it is alive does not exist.");
    } else return health > 0;
  }

  /**
   * Getter for Attack
   * @return Attack of Card
  */
  public int getAttack() {
    //if this Card has a buff active
    if (this.buff != null) {
      //check if attack with buff applied is lower than 0
      if ((this.buff.getAttackBuff() + this.baseAttack) < 0) {
        return 0; //returns 0 if lower than 0
        //returns "true" value if bigger than 0 or 0
      } else return this.buff.getAttackBuff() + this.baseAttack;
    } else return this.baseAttack; //returns baseAttack if no buff active
  }
  
  
  /**
   * Getter for Defense
   * @return Defense of Card
  */
  public int getDefense() { 
    //if this Card has a buff active
    if (this.buff != null) {
      //check if Defense with buff applied is lower than 0
      if ((this.buff.getDefenseBuff() + this.baseDefense) < 0) {
        return 0; //returns 0 if lower than 0
        //returns "true" value if bigger than 0 or 0
      } else return buff.getDefenseBuff() + this.baseDefense;
    } else return this.baseDefense;
  }

  /**
   * Attack other Card with this Card
   * @param otherCard The card to be attacked
  */
  public void attack(Card otherCard) {
    //checks if other Card is valid is not null
    if (otherCard == null) {
      throw new IllegalArgumentException("The Card being attacked is null.");
    }
    // checks if both card are dead
    if (!(otherCard.isAlive()) || !(this.isAlive())) {
      throw new IllegalArgumentException("Both cards need to be alive to perform this action");
    }
    // checks if Defense of attacked card is smaller than Attack of attacker
    if (otherCard.getDefense() < this.getAttack()) {
      //subtracts difference of Attackers attack and defenders defense from defenders health
      otherCard.health = otherCard.health - (this.getAttack() - otherCard.getDefense());
      // sets other cards health to 0 if its lower than 0 after the attack
      if (otherCard.health < 0) {
        otherCard.health = 0;
      }
    }
    return;
  }

  /**
   * Getter for Category of Card
   * @return Category of Card
  */
  public Category getCategory() {
    return this.category;
  }

  /**
   * Getter for Health of Card
   * @return Health of Card
  */
  public int getHealth() {
    return this.health;
  }
  
  // returns values of Card in String in printable format
  public String toString() {
    //if buff is null, print buff as NULL
    if (this.buff == null) {
      return "Name: "
          + this.name
          + "%nbase Defense: "
          + Integer.toString(this.baseDefense)
          + "%n base Attack: "
          + Integer.toString(baseAttack)
          + "%n Category: "
          + this.category.gName()
          + "%n Health: "
          + Integer.toString(this.health)
          + "%n Buff: NULL %n";
    } else
      //includes Buff name in String
      return "Name: "
          + this.name
          + "%nbase Defense: "
          + Integer.toString(this.baseDefense)
          + "%n base Attack: "
          + Integer.toString(baseAttack)
          + "%n Category: "
          + this.category.gName()
          + "%n Health: "
          + Integer.toString(this.health)
          + "%n Buff: "
          + this.buff.getName()
          + "%n";
  }

  /**
   * Checks if Card equals another card
   * @param other  Card to be compared to
   * @return True if Cards are equal
   */
  public boolean equals(Card other) {
    boolean isEqual = false;
    // returns false if other Card is null (needed for check of other.buff)
    if (other == null) {
      isEqual = false;
    }
    // returns false if either card buff is null
    else if (other.buff == null ^ this.buff == null) {
      isEqual = false;
    }
    // if other Cards buff is not null, check if its the same as this Cards buff
    else if (other.buff != null) {
      if (!(other.buff.equals(this.buff))) {
        isEqual = false; //returns false if other buff != this buff
      }
    }
    // checks if other Card values match
    else if (other.getName() == this.name
        && other.getBaseDefense() == this.baseDefense
        && other.getBaseAttack() == this.baseAttack
        && other.getCategory() == this.category
        && other.getHealth() == this.health) {
      isEqual = true;
    }
    return isEqual; //returns false if not all match
  }
}
