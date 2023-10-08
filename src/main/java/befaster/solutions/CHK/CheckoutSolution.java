package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
  private static final HashMap<String, Integer> itemToPrice = new HashMap<>();

  static {
    itemToPrice.put("A", 50);
    itemToPrice.put("B", 30);
    itemToPrice.put("C", 20);
    itemToPrice.put("D", 15);
    itemToPrice.put("E", 40);
  }
  //  private static final Item itemA = new Item(A, 50);
  //  private static final Item itemB = new Item(B, 30);
  //  private static final Item itemC = new Item(C, 20);
  //  private static final Item itemD = new Item(D, 15);
  //  private static final Item itemE = new Item(E, 40);

  private static final DiscountStrategy discountStrategy1 = new DiscountStrategy("A", 3, 130);
  private static final DiscountStrategy discountStrategy2 = new DiscountStrategy("A", 5, 200);
  private static final DiscountStrategy discountStrategy3 = new DiscountStrategy("B", 2, 45);
  private static final List<DiscountStrategy> discountStrategies = List.of(discountStrategy1, discountStrategy2,
      discountStrategy3);
  private static final FreeItemStrategy freeItemStrategy = new FreeItemStrategy("E", 2, "B");

  private int applyDiscountStrategy(HashMap<String, Integer> itemToCount, DiscountStrategy discountStrategy) {
    int discountedPrice = 0;
    String itemName = discountStrategy.getItemName();
    Integer itemCount = itemToCount.get(itemName);
    int numDiscountedItems = itemCount / discountStrategy.numOfItems;
    discountedPrice += numDiscountedItems * discountStrategy.discountedPrice;
    int normalPriceItems = itemCount % discountStrategy.numOfItems;
    itemToCount.put(itemName, normalPriceItems);
    return discountedPrice;
  }

  private void applyFreeItemStrategy(HashMap<String, Integer> itemToCount, FreeItemStrategy freeItemStrategy) {
    String itemName = freeItemStrategy.getItemName();
    Integer itemCount = itemToCount.get(itemName);
    String freeItem = freeItemStrategy.getFreeItemName();
    itemToCount.put(freeItem, itemToCount.get(freeItem) - (itemCount / freeItemStrategy.numOfItems));
  }

  private int applyNormalPrice(HashMap<String, Integer> itemToCount) {
    int sum = 0;
    for (Map.Entry<String, Integer> entry : itemToCount.entrySet()) {
      String itemName = entry.getKey();
      int count = entry.getValue();
      sum += itemToPrice.get(itemName) * count;
    }
    return sum;
  }

  public Integer checkout(String skus) {
    StringBuilder str = new StringBuilder(skus);
    HashMap<String, Integer> itemToCount = new HashMap<>();
    itemToCount.put("A", 0);
    itemToCount.put("B", 0);
    itemToCount.put("C", 0);
    itemToCount.put("D", 0);
    itemToCount.put("E", 0);
    for (int i = 0; i < skus.length(); i++) {
      String currentItem = String.valueOf(str.charAt(i));
      if (!"ABCD".contains(currentItem)) {
        return -1;
      }
      itemToCount.put(currentItem, itemToCount.get(currentItem) + 1);
    }

    int sum = 0;
    for (DiscountStrategy discountStrategy : discountStrategies) {
      sum += applyDiscountStrategy(itemToCount, discountStrategy);
    }
    applyFreeItemStrategy(itemToCount, freeItemStrategy);
    return sum + applyNormalPrice(itemToCount);

    //    for (Map.Entry<Character, Integer> countEntry : mapCount.entrySet()) {
    //      if (countEntry.getKey() == 'A') {
    //        if (countEntry.getValue() >= 3) {
    //          int offerPrice = countEntry.getValue() / 3 * 130;
    //          int restPrice = countEntry.getValue() % 3 * mapPrices.get('A');
    //          sum += offerPrice + restPrice;
    //        } else
    //          sum += countEntry.getValue() * mapPrices.get('A');
    //      }
    //    return sum;
  }
}


