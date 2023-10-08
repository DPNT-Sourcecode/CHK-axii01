package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

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
    for (String item : itemNames) {
      if (itemToCount.get(item) != null) {
        totalItems += itemToCount.get(item);
      }
    }
    if (totalItems >= numOfItems) {
      price = totalItems / numOfItems * discountedPrice;
      int countToRemove = totalItems - totalItems % numOfItems;
      for (String item : itemNames) {
        if (countToRemove > 0) {
          Integer count = itemToCount.get(item);
          if (count != null && count > 0) {
            itemToCount.put(item, count - 1);
            countToRemove--;
          }
        } else
          break;
      }
    }
    return price;
  }
}




