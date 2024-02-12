public class BattleLocation extends Location {

  Monster monster;

  BattleLocation(Player player, String name, Monster monster) {
    super(player);
    this.monster = monster;
    this.name = name;
  }

  @Override
  public boolean getLocation() {
    return false;
  }
}
