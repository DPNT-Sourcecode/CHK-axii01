package befaster.solutions.CHK;

public class Item {
  public Character getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  Character name;
  int price;

  public Item(Character name, int price) {
    this.name = name;
    this.price = price;
  }
}

