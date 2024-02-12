public class SafeLocation extends Location {

  SafeLocation(Player player, String name) {
    super(player);
    this.name = name;
  }

  @Override
  public boolean getLocation() {
    return false;
  }
}
