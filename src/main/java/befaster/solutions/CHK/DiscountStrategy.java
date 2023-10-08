package befaster.solutions.CHK;

import java.util.HashMap;

public class DiscountStrategy {

  String itemName;
  int numOfItems;
  int discountedPrice;

  public DiscountStrategy(String itemName, int numOfItems, int discountedPrice) {
    this.itemName = itemName;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public int getDiscountedPrice() {
    return discountedPrice;
  }

  public int applyStrategy(HashMap<String, Integer> itemToCount) {
    Integer itemCount = itemToCount.get(itemName);
    int numDiscountedItems = itemCount / numOfItems;
    int price = numDiscountedItems * discountedPrice;
    int normalPriceItems = itemCount % numOfItems;
    itemToCount.put(itemName, normalPriceItems);
    return price;
  }
}

