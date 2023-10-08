package befaster.solutions.CHK;

import java.util.HashMap;

public class DiscountStrategy implements Strategy {

  String itemName;
  int numOfItems;
  int discountedPrice;

  public DiscountStrategy(String itemName, int numOfItems, int discountedPrice) {
    this.itemName = itemName;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  @Override public int apply(HashMap<String, Integer> itemToCount) {
    int price = 0;
    if (itemToCount.containsKey(itemName)) {
      Integer itemCount = itemToCount.get(itemName);
      int numDiscountedItems = itemCount / numOfItems;
      price = numDiscountedItems * discountedPrice;
      int normalPriceItems = itemCount % numOfItems;
      itemToCount.put(itemName, normalPriceItems);
    }
    return price;
  }
}
