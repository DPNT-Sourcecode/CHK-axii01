package befaster.solutions.CHK;

public class FreeItemStrategy {
  String ItemName;
  int numOfItemNames;
  String freeItemName;

  public FreeItemStrategy(String ItemName, int numOfItemNames, String freeItemName) {
    this.ItemName = ItemName;
    this.numOfItemNames = numOfItemNames;
    this.freeItemName = freeItemName;
  }

  public String getItemName() {
    return ItemName;
  }

  public int getNumOfItemNames() {
    return numOfItemNames;
  }

  public String getFreeItemName() {
    return freeItemName;
  }
}
