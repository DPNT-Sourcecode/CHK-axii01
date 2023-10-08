package befaster.solutions.CHK;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
  //  private static final HashMap<String, Integer> itemToPrice = new HashMap<>();
  //
  //  static {
  //    itemToPrice.put("A", 50);
  //    itemToPrice.put("B", 30);
  //    itemToPrice.put("C", 20);
  //    itemToPrice.put("D", 15);
  //    itemToPrice.put("E", 40);
  //    itemToPrice.put("F", 10);
  //  }

  private static final DiscountStrategy discountStrategy1 = new DiscountStrategy("A", 5, 200);
  private static final DiscountStrategy discountStrategy2 = new DiscountStrategy("A", 3, 130);
  private static final DiscountStrategy discountStrategy3 = new DiscountStrategy("B", 2, 45);
  private static final List<DiscountStrategy> discountStrategies = List.of(discountStrategy1, discountStrategy2,
      discountStrategy3);
  private static final FreeItemStrategy freeItemStrategy1 = new FreeItemStrategy("E", 2, "B");
  private static final FreeItemStrategy freeItemStrategy2 = new FreeItemStrategy("F", 2, "F");
  private static final List<FreeItemStrategy> freeItemStrategies = List.of(freeItemStrategy1, freeItemStrategy2);
  //
  //  private int applyDiscountStrategy(HashMap<String, Integer> itemToCount, DiscountStrategy discountStrategy) {
  //    int discountedPrice = 0;
  //    String itemName = discountStrategy.getItemName();
  //    Integer itemCount = itemToCount.get(itemName);
  //    int numDiscountedItems = itemCount / discountStrategy.numOfItems;
  //    discountedPrice += numDiscountedItems * discountStrategy.discountedPrice;
  //    int normalPriceItems = itemCount % discountStrategy.numOfItems;
  //    itemToCount.put(itemName, normalPriceItems);
  //    return discountedPrice;
  //  }

  //  private void applyFreeItemStrategy(HashMap<String, Integer> itemToCount, FreeItemStrategy freeItemStrategy) {
  //    String itemName = freeItemStrategy.getItemName();
  //    Integer itemCount = itemToCount.get(itemName);
  //    String freeItem = freeItemStrategy.getFreeItemName();
  //    int freeItemCount = itemToCount.get(freeItem);
  //    itemToCount.put(freeItem,
  //        itemToCount.get(freeItem) - Math.min((itemCount / freeItemStrategy.numOfItems), freeItemCount));
  //  }

  //  private int applyNormalPrice(HashMap<String, Integer> itemToCount) {
  //    int sum = 0;
  //    for (Map.Entry<String, Integer> entry : itemToCount.entrySet()) {
  //      String itemName = entry.getKey();
  //      int count = entry.getValue();
  //      sum += itemToPrice.get(itemName) * count;
  //    }
  //    return sum;
  //  }

  public Integer checkout(String skus) {
    StringBuilder str = new StringBuilder(skus);
    HashMap<String, Integer> itemToCount = new HashMap<>();
    itemToCount.put("A", 0);
    itemToCount.put("B", 0);
    itemToCount.put("C", 0);
    itemToCount.put("D", 0);
    itemToCount.put("E", 0);
    itemToCount.put("F", 0);
    for (int i = 0; i < skus.length(); i++) {
      String currentItem = String.valueOf(str.charAt(i));
      if (itemToCount.get(currentItem) == null) {
        return -1;
      }
      itemToCount.put(currentItem, itemToCount.get(currentItem) + 1);
    }

    //    applyFreeItemStrategy(itemToCount, freeItemStrategy1);
    //    applyFreeItemStrategy(itemToCount, freeItemStrategy2);

    for (FreeItemStrategy freeItemStrategy : freeItemStrategies) {
      freeItemStrategy.applyStrategy(itemToCount);
    }
    int sum = 0;
    for (DiscountStrategy discountStrategy : discountStrategies) {
      sum += discountStrategy.applyStrategy(itemToCount);
    }
    return sum + NormalPriceStrategy.applyStrategy(itemToCount);
  }
}



