/**
 * @author : Elias Haberl
 * @created : 2022-06-02
**/
package casino;

import java.util.Scanner;

/**
 * GamblingUI
 */
public class GamblingUI {
    public static RouletteGameType chooseRouletteType(Scanner rouletteTypeScanner) {

    System.out.printf("Choose your preferred Roulette Type with the numbers next to them\n");

    int userIn = 11;
    int nr;

    while (userIn < 1 || userIn > 10) {
      nr = 1;
      System.out.printf("Please choose a value of 1-10\n");
      for (RouletteGameType rouletteType : RouletteGameType.values()) {
        System.out.printf("%d: %s\n", nr, rouletteType);
        nr++;
      }
      userIn = rouletteTypeScanner.nextInt();
      rouletteTypeScanner.nextLine();
    }
    rouletteTypeScanner.close();
    RouletteGameType[] rouletteGameTypeArray = RouletteGameType.values();
    RouletteGameType rType = rouletteGameTypeArray[userIn-1];
    return rType;
  }
  
  public static int chooseMachineType(Scanner machineTypeScanner) {

    System.out.printf("Choose your preferred Machine Type\n");
    System.out.printf("0: Return to machine type choice menu \n");
    System.out.printf("1: Roulette \n");
    System.out.printf("2: DoubleShot \n");
    System.out.printf("3: ArcadeFun \n");

    int userIn = 5;
    while (userIn < 0 || userIn > 3) {
      System.out.printf("Please choose a value of 0-3\n");
      userIn = machineTypeScanner.nextInt();
    }
    return userIn;
  }

  public static SlotMachine createActiveMachine (int machineType){
  SlotMachine newMachine = new DoubleShot("activeDoubleShot");
  return newMachine;
  }
  public static SlotMachine createActiveMachine (int machineType, RouletteGameType rouletteType){
  SlotMachine newMachine = new Roulette("activeRoulette", rouletteType);
  return newMachine;
  }

  /**
   * Prints a statusbar
   * @param wallet
   * @param credits
  */
  public void printStatusbar(int wallet, int credits) {
    System.out.printf("Wallet: %d\t|\tCredits: %d\t|\t\n", wallet);
  }

  
  public void printChooseStakes(){
    System.out.printf("Please enter your preferred stakes, 1-10 \n");
  }
  public void printRouletteInterfaceNUMBER(Roulette r) {
     
    // r.play()
  }


  

}
