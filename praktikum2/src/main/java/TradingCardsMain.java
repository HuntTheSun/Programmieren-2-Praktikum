/**
 * @author : Elias Haberl
 * @created : 2022-04-14
**/


/**
 * A Program for simulating a trading cards game
 * */
public class TradingCardsMain {
  /**
   * Main method of game
   * @param args  No arguments used
  */
  public static void main(String[] args) {
    Buff defenseBuff = new Buff("Defense", 2, 0);
    Buff rageBuff = new Buff("Rage", -2, 4);
    System.out.println(defenseBuff.toString()); 
    System.out.println(rageBuff.toString()); 
    System.out.println();
    for (Category c : Category.values()) {
      System.out.printf("Name: %s, Description: %s%n",
          c.gName(), c.gDesc());
    }

    Card wolf = new Card("Wolf", 1, 3, Category.ANIMAL, 2);
    Card lawnMower = new Card("Lawn Mower", 3, 1, Category.MACHINE, 4);
    Card unicorn = new Card("Unicorn", 3, 3, Category.MAGICAL_CREATURE, 1);
    Card manchineelTree = new Card("Manchineel Tree", 1, 4, Category.PLANT, 5);
    
     
    System.out.printf(wolf.toString());
    System.out.printf(lawnMower.toString());
    System.out.printf(unicorn.toString());
    System.out.printf(manchineelTree.toString());
    System.out.printf("%n");

    wolf.attack(lawnMower);
    System.out.printf(lawnMower.toString());
    lawnMower.setBuff(defenseBuff);
    wolf.attack(lawnMower);
    System.out.printf(lawnMower.toString());
    lawnMower.attack(wolf);
    System.out.printf(wolf.toString());
    unicorn.attack(manchineelTree);
    System.out.printf(manchineelTree.toString());
    manchineelTree.setBuff(rageBuff);
    manchineelTree.attack(unicorn);
    unicorn.attack(manchineelTree);


  return;
  }
}

