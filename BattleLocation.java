public class BattleLocation extends Location {

  protected Monster monster;
  protected String award;

  BattleLocation(Player player, String name, Monster monster, String award) {
    super(player);
    this.monster = monster;
    this.name = name;
    this.award = award;
  }

  @Override
  public boolean getLocation() {
    int obsCount = monster.count();
    System.out.println(this.getName() + " you are currently here");
    System.out.println(
      "Be aware !! There are " + obsCount + " " + monster.getName() + "s"
    );
    System.out.print("<F>ight or <R>un away: ");
    String selCase = scan.nextLine().toUpperCase();
    System.out.println(selCase);

    if (selCase.equals("F")) {
      if (combat(obsCount)) {
        System.out.println("Well done !! You killed all the enemies");
        if (this.award.equals("Food") && player.getInv().isFood() == false) {
          System.out.println("You found: " + this.award);
          player.getInv().setFood(true);
        } else if (
          this.award.equals("Firewood") && player.getInv().isFirewood() == false
        ) {
          System.out.println("You found: " + this.award);
          player.getInv().setFirewood(true);
        } else if (
          this.award.equals("Water") && player.getInv().isFood() == false
        ) {
          System.out.println("You found: " + this.award);
          player.getInv().setWater(true);
        }
      }
      if (player.getHealth() <= 0) {
        System.out.println("You are dead!");
        return false;
      }
    }

    return true;
  }

  public boolean combat(int obsCount) {
    int aliveMonsterCount = obsCount;
    for (int i = 0; i < obsCount; i++) {
      int defaultMonsterHealth = monster.getHealth();
      printPlayerStats();
      printEnemyStats();

      while (player.getHealth() > 0 && monster.getHealth() > 0) {
        System.out.println("<A>ttack or <R>un away");
        String selectCase = scan.nextLine().toUpperCase();
        if (selectCase.equals("A")) {
          System.out.println("You hitted monster");
          monster.setHealth(monster.getHealth() - player.getTotalDamage());
          System.out.println("Player's health: " + player.getHealth());
          System.out.println("Monster's health: " + monster.getHealth());

          if (monster.getHealth() >= 0) {
            System.out.println("Monster hitted you");
            player.setHealth(
              player.getHealth() -
              (
                (aliveMonsterCount * monster.getDamage()) <
                  player.getInv().getArmour()
                  ? 0
                  : (
                    (aliveMonsterCount * monster.getDamage()) -
                    player.getInv().getArmour()
                  )
              )
            );
            System.out.println("Player's health: " + player.getHealth());
            System.out.println("Monster's health: " + monster.getHealth());
          }
        } else {
          return true;
        }
      }

      if (monster.getHealth() < 0 && player.getHealth() > 0) {
        System.out.println("You killed the enemy");
        player.setMoney(player.getMoney() + monster.getAward());
        System.out.println("Current money: " + player.getMoney());
        monster.setHealth(defaultMonsterHealth);
        aliveMonsterCount--;
      } else {
        return false;
      }
    }
    return true;
  }

  public void printPlayerStats() {
    System.out.println("Player Stats \n -------");
    System.out.println("Health : \t" + player.getHealth());
    System.out.println("Damage : \t" + player.getTotalDamage());
    System.out.println("Money : \t" + player.getMoney());
    if (player.getInv().getDamage() > 0) System.out.println(
      "Weapon \t: " + player.getInv().getWeaponName()
    );
    if (player.getInv().getArmour() > 0) System.out.println(
      "Armour \t: " + player.getInv().getArmourName()
    );
  }

  public void printEnemyStats() {
    System.out.println(monster.getName() + "'s stats \n -------");
    System.out.println("Health : \t" + monster.getHealth());
    System.out.println("Damage : \t" + monster.getDamage());
    System.out.println("Money : \t" + monster.getAward());
  }
}
