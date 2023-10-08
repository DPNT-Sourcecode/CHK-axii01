package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {
  private static final HashMap<String, Integer> itemToPrice = new HashMap<>();

  static {
    itemToPrice.put("A", 50);
    itemToPrice.put("B", 30);
    itemToPrice.put("C", 20);
    itemToPrice.put("D", 16);
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
//    int normalPrice = itemCount % discountStrategy.numOfItems * itemToPrice.get(itemName);

    return discountedPrice;
  }

  public Integer checkout(String skus) {
    StringBuilder str = new StringBuilder(skus);
    HashMap<String, Integer> itemToCount = new HashMap<>();
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
    //    sum += applyPriceStrategy(itemToCount, discountStrategy);

    //    for (Map.Entry<Character, Integer> countEntry : mapCount.entrySet()) {
    //      if (countEntry.getKey() == 'A') {
    //        if (countEntry.getValue() >= 3) {
    //          int offerPrice = countEntry.getValue() / 3 * 130;
    //          int restPrice = countEntry.getValue() % 3 * mapPrices.get('A');
    //          sum += offerPrice + restPrice;
    //        } else
    //          sum += countEntry.getValue() * mapPrices.get('A');
    //      }
    //
    //      if (countEntry.getKey() == 'B') {
    //        if (countEntry.getValue() >= 2) {
    //          int offerPrice = countEntry.getValue() / 2 * 45;
    //          int restPrice = countEntry.getValue() % 2 * mapPrices.get('B');
    //          sum += offerPrice + restPrice;
    //        } else
    //          sum += countEntry.getValue() * mapPrices.get('B');
    //      }
    //
    //      if (countEntry.getKey() == 'C') {
    //        sum += countEntry.getValue() * mapPrices.get('C');
    //      }
    //
    //      if (countEntry.getKey() == 'D') {
    //        sum += countEntry.getValue() * mapPrices.get('D');
    //      }
    //    }

    return sum;
  }
}




