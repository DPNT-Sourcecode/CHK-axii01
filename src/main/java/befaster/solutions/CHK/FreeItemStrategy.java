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

  @Override public int apply(HashMap<String, Integer> itemToCount) {
    Integer itemCount = itemToCount.get(itemName);
    int freeItemCount = itemToCount.get(freeItemName);

    itemToCount.put(freeItemName, itemToCount.get(freeItemName) - Math.min((itemCount / numOfItems), freeItemCount));
    return 0;
  }
}




