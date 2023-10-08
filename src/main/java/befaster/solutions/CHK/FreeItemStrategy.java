package befaster.solutions.CHK;

public class FreeItemStrategy {
  Item item;
  int numOfItems;
  Item freeItem;

  public FreeItemStrategy(Item item, int numOfItems, Item freeItem) {
    this.item = item;
    this.numOfItems = numOfItems;
    this.freeItem = freeItem;
  }

  public Item getItem() {
    return item;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public Item getFreeItem() {
    return freeItem;
  }
}

