/**
 * @author : Elias Haberl
 * @created : 2022-04-14
 **/

/** Declaration of Categories in enum
 **/
public enum Category {
  // Declaration of different Categories
  ANIMAL ("Animal", "Animals roaming the land"),
  MACHINE ("Robot", "Robots from the far future"),
  MAGICAL_CREATURE ("Magical Creature", "Magical creature from a mystical plane"),
  PLANT ("Plant", "Awoken plants that defend themselves");

  // attributes of Category
  private final String name;
  private final String description;

  /**
   * Constructor for Category
   * @param n Name of category
   * @param d Description of category
  */
  Category(String n, String d){
    this.name = n;
    this.description = d;
  }

  //getter Methods
  /**
   * Getter for Name of Category
   * @return Name of Category
  */
  public String gName() { return this.name; }
  /**
   * Getter for Description of Category
   * @return Description of Category
  */
  public String gDesc() { return this.description; }

}



