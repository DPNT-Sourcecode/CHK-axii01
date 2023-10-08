package befaster.solutions.CHK;

import java.util.HashMap;

public class FreeItemStrategy implements Strategy {
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

  @Override public int apply(HashMap<String, Integer> itemToCount) {
    Integer itemCount = itemToCount.get(itemName);
    int freeItemCount = itemToCount.get(freeItemName);
    itemToCount.put(freeItemName, itemToCount.get(freeItemName) - Math.min((itemCount / numOfItems), freeItemCount));
    return 0;
  }
}


