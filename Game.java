import java.util.Scanner;

public class Game {

  Player player;
  Location location;
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {}

  public void init() {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to game !!");

    System.out.print("Enter your characters name: ");
    String playerName = input.nextLine();
    this.player = new Player(playerName);
    this.player.selectCharacter();
  }

  public void start() {
    while (true) {
      System.out.println("");
      System.out.println("================");
      System.out.println();
      System.out.println("1-Home --> Safe place , No enemy");
      System.out.println("2-Cave --> You will encounter with zombies ");
      System.out.println("3-Forest --> You will encounter with vampire ");
      System.out.println("4-River --> You will encounter with bear ");
      System.out.println("5-Store --> You can buy armour and weapon ");
      System.out.print("Choose location: ");

      int locChoice = input.nextInt();

      while (locChoice > 5 || locChoice < 0) {
        System.out.println("1-Home --> Safe place , No enemy");
        System.out.println("2-Cave --> You will encounter with zombies ");
        System.out.println("3-Forest --> You will encounter with vampire ");
        System.out.println("4-River --> You will encounter with bear ");
        System.out.println("5-Store --> You can buy armour and weapon ");
        System.out.print("Choose valid location: ");
        locChoice = input.nextInt();
      }

      System.out.println("\n \n ");

      switch (locChoice) {
        case 1:
          System.out.println("-----------");
          location = new House(player);
          break;
        case 2:
          System.out.println("-----------");

          location = new Cave(player);
          break;
        case 3:
          System.out.println("-----------");

          location = new Forest(player);
          break;
        case 4:
          System.out.println("-----------");

          location = new River(player);
          break;
        case 5:
          System.out.println("-----------");

          location = new Store(player);
          break;
      }

      if (location.getClass().getName().equals("House")) {
        if (
          player.getInv().isFood() &&
          player.getInv().isFirewood() &&
          player.getInv().isWater()
        ) {
          System.out.println("You win!!");
          break;
        }
      }

      System.out.println(location.getName());

      location.getLocation();
    }
  }
}
