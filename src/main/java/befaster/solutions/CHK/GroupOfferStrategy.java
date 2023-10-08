package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupOfferStrategy implements Strategy {
  private final List<String> itemNames;
  private final int numOfItems;
  private final int discountedPrice;

  public GroupOfferStrategy(List<String> itemNames, int numOfItems, int discountedPrice) {
    this.itemNames = itemNames;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  @Override public int apply(HashMap<String, Integer> itemToCount) {
    int totalItems = 0;
    int price = 0;
    for (Map.Entry<String, Integer> entry : itemToCount.entrySet()) {
      if (itemNames.contains(entry.getKey())) {
        totalItems += entry.getValue();
      }
    }
    if (totalItems >= numOfItems) {
      price = totalItems / numOfItems * discountedPrice;
      int countToRemove = totalItems - totalItems % numOfItems;
      
    }
    return price;
  }
}


