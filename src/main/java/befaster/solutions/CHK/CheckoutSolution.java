package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {

  private static final DiscountStrategy discountStrategy1 = new DiscountStrategy("A", 5, 200);
  private static final DiscountStrategy discountStrategy2 = new DiscountStrategy("A", 3, 130);
  private static final DiscountStrategy discountStrategy3 = new DiscountStrategy("B", 2, 45);
  private static final DiscountStrategy discountStrategy4 = new DiscountStrategy("F", 3, 20);
  private static final FreeItemStrategy freeItemStrategy1 = new FreeItemStrategy("E", 2, "B");
//  private static final FreeItemStrategy freeItemStrategy2 = new FreeItemStrategy("F", 2, "F");
  private static final List<Strategy> allStrategies = List.of(freeItemStrategy1, discountStrategy1,
      discountStrategy2, discountStrategy3, discountStrategy4, new NormalPriceStrategy());

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

    return allStrategies.stream().mapToInt(strategy -> strategy.apply(itemToCount)).sum();
  }
}

