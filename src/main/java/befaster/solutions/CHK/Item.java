package befaster.solutions.CHK;

public class Item {
  public ItemName getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  ItemName name;
  int price;

  public Item(ItemName name, int price) {
    this.name = name;
    this.price = price;
  }
}
