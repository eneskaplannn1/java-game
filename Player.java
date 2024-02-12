import java.util.Scanner;

public class Player {

  private int damage, money, health, totalHealth;
  private String name, cName;
  private Inventory inv;
  private Scanner scan = new Scanner(System.in);

  public Player(String name) {
    this.name = name;
    this.inv = new Inventory();
  }

  public void selectCharacter() {
    switch (characterMenu()) {
      case 1:
        System.out.println("Samurai character chosen.");
        initPlayer("Samurai", 5, 21, 15);
        break;
      case 2:
        System.out.println("Archer character chosen.");
        initPlayer("Archer", 7, 18, 20);
        break;
      case 3:
        System.out.println("Knight character chosen.");
        initPlayer("Knight", 8, 24, 5);
        break;
    }
  }

  private int characterMenu() {
    System.out.println("Hello " + this.name);
    System.out.println("Please select a character");
    System.out.println("1-Samurai ,\t Damage ; 5 ,\t Health 21 ;\t Money ; 15");
    System.out.println("2-Archer ,\t Damage ; 7 ,\t Health 18 ;\t Money ; 20");
    System.out.println("3-Knight ,\t Damage ; 8 ,\t Health 24 ;\t Money ; 5");
    System.out.print("Enter your choice: ");

    int choice = scan.nextInt();

    while (3 < choice || choice < 1) {
      System.out.println("\n \n \n");

      System.out.println(
        "1-Samurai ,\t Damage ; 5 ,\t Health 21 ;\t Money ; 15"
      );
      System.out.println(
        "2-Archer ,\t Damage ; 7 ,\t Health 18 ;\t Money ; 20"
      );
      System.out.println("3-Knight ,\t Damage ; 8 ,\t Health 24 ;\t Money ; 5");
      System.out.println("Enter valid arguement");

      choice = scan.nextInt();
    }

    return choice;
  }

  public void initPlayer(String cName, int damage, int health, int money) {
    setDamage(damage);
    setHealth(health);
    setTotalHealth(health);
    setcName(cName);
    setMoney(money);
  }

  public int getTotalHealth() {
    return totalHealth;
  }

  public void setTotalHealth(int totalHealth) {
    this.totalHealth = totalHealth;
  }

  public Scanner getScan() {
    return scan;
  }

  public void setScan(Scanner scan) {
    this.scan = scan;
  }

  public int getDamage() {
    return damage;
  }

  public int getMoney() {
    return money;
  }

  public int getHealth() {
    return health;
  }

  public String getName() {
    return name;
  }

  public String getcName() {
    return cName;
  }

  public Inventory getInv() {
    return inv;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }

  public void setInv(Inventory inv) {
    this.inv = inv;
  }
}
