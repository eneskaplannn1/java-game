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
        break;
      case 2:
        itemId = armourMenu();
        buyArmour(itemId);
        break;
      case 3:
        break;
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
        break;
      case 2:
        damage = 4;
        wName = "Sword";
        price = 35;
        break;
      case 3:
        damage = 7;
        wName = "Rifle";
        price = 45;
        break;
      case 4:
        System.out.println("Leaving out..");
        break;
      default:
        System.out.println("Invalid action");
        break;
    }
    if (player.getMoney() >= price && (price > 0)) {
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
    } else if (weaponId != 4) {
      System.out.println("You dont have enough credit");
    }
  }

  public int armourMenu() {
    System.out.println("1. Light armor \t <Cost : 15 - Avoid - 2>");
    System.out.println("2. Medium armor \t <Cost : 25 - Avoid - 4>");
    System.out.println("3. Heavy armor \t <Cost : 40 - Avoid - 7>");
    System.out.println("4. Exit");
    System.err.print("Enter your choice: ");

    return scan.nextInt();
  }

  public void buyArmour(int armourId) {
    int armour = 0, price = 0;
    String aName = null;
    switch (armourId) {
      case 1:
        armour = 2;
        aName = "Light";
        price = 15;
        break;
      case 2:
        armour = 4;
        aName = "Medium";
        price = 25;
        break;
      case 3:
        armour = 7;
        aName = "Heavy";
        price = 40;
        break;
      case 4:
        System.out.println("Leaving out..");
        break;
      default:
        System.out.println("Invalid action");
        break;
    }
    if (player.getMoney() >= price && (price > 0)) {
      player.getInv().setArmour(armour);
      player.getInv().setArmourName(aName);
      player.setMoney(player.getMoney() - price);
      System.out.println(
        "Your resistance: " + armour + player.getInv().getArmour()
      );
      System.out.println("Your credit: " + player.getMoney());
    } else if (armourId != 4) {
      System.out.println("You dont have enough credit");
    }
  }
}
