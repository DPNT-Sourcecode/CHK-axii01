package befaster.solutions.CHK;

public class FreeItemStrategy {
  ItemName ItemName;
  int numOfItemNames;
  ItemName freeItemName;

  public FreeItemStrategy(ItemName ItemName, int numOfItemNames, ItemName freeItemName) {
    this.ItemName = ItemName;
    this.numOfItemNames = numOfItemNames;
    this.freeItemName = freeItemName;
  }

  public ItemName getItemName() {
    return ItemName;
  }

  public int getNumOfItemNames() {
    return numOfItemNames;
  }

  public ItemName getFreeItemName() {
    return freeItemName;
  }
}


