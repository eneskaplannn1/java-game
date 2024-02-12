import javax.management.loading.PrivateClassLoader;

public class Store extends SafeLocation {

  Store(Player player) {
    super(player, "Store");
  }

  @Override
  public boolean getLocation() {
    System.err.println("Players money = " + player.getMoney());
    System.out.println("1. Weapons");
    System.out.println("2. Armours");
    System.out.println("3. Exit");
    System.out.print("Your choice: ");
    int choice = scan.nextInt();
    int itemId;

    switch (choice) {
      case 1:
        itemId = weaponMenu();
        buyWeapon(itemId);
      //   case 2:
      //     itemId = armourMenu();
      //     buyArmour(itemId);
      //   case 3:
    }

    return true;
  }

  public int weaponMenu() {
    System.out.println("1. Gun <Cost : 25 - Damage - 2>");
    System.out.println("2. Sword <Cost : 35 - Damage - 3>");
    System.out.println("3. Rifle <Cost : 45 - Damage - 7>");
    System.out.println("4. Exit");
    System.err.print("Enter your choice: ");

    return scan.nextInt();
  }

  public void buyWeapon(int weaponId) {
    int damage = 0, price = 0;
    String wName = null;
    switch (weaponId) {
      case 1:
        damage = 2;
        wName = "Gun";
        price = 25;
      case 2:
        damage = 4;
        wName = "Sword";
        price = 35;
      case 3:
        damage = 7;
        wName = "Rifle";
        price = 45;
      default:
        System.out.println("Invalid action");
    }
    if (player.getMoney() > price) {
      player.getInv().setDamage(damage);
      player.getInv().setWeaponName(wName);
      player.setMoney(player.getMoney() - price);
      System.out.println(
        "You buyed " +
        wName +
        " previous damage: " +
        player.getDamage() +
        " current damage: " +
        (player.getDamage() + player.getInv().getDamage())
      );
    } else {
      System.out.println("You dont have enough credit");
    }
  }
}
