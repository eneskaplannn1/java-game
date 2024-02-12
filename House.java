public class House extends SafeLocation {

  House(Player player) {
    super(player, "House");
  }

  @Override
  public boolean getLocation() {
    player.setHealth(player.getTotalHealth());
    System.out.println("You healed , your health is " + player.getHealth());
    System.out.println("You are currently in house");
    return true;
  }
}
