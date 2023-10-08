package befaster.solutions.CHK;

public class FreeItemStrategy {
  String itemName;
  int numOfItems;
  String freeItemName;

  public FreeItemStrategy(String ItemName, int numOfItemNames, String freeItemName) {
    this.itemName = ItemName;
    this.numOfItems = numOfItemNames;
    this.freeItemName = freeItemName;
  }

  public String getItemName() {
    return itemName;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public String getFreeItemName() {
    return freeItemName;
  }
}
