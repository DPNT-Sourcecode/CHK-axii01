package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {

  private static final DiscountStrategy discountStrategy1 = new DiscountStrategy("A", 5, 200);
  private static final DiscountStrategy discountStrategy2 = new DiscountStrategy("A", 3, 130);
  private static final DiscountStrategy discountStrategy3 = new DiscountStrategy("B", 2, 45);
  private static final DiscountStrategy discountStrategy4 = new DiscountStrategy("F", 3, 20);
  private static final FreeItemStrategy freeItemStrategy1 = new FreeItemStrategy("E", 2, "B");
  private static final List<Strategy> allStrategies = List.of(freeItemStrategy1, discountStrategy1, discountStrategy2,
      discountStrategy3, discountStrategy4, new NormalPriceStrategy());

  public Integer checkout(String skus) {
    StringBuilder str = new StringBuilder(skus);
    HashMap<String, Integer> itemToCount = new HashMap<>();
    for (int i = 0; i < skus.length(); i++) {
      char currentChar = str.charAt(i);
      if (!Character.isUpperCase(currentChar) || !Character.isLetter(currentChar)) {
        return -1;
      }
      String currentItem = String.valueOf(currentChar);
      if (itemToCount.containsKey(currentItem)) {
        itemToCount.put(currentItem, itemToCount.get(currentItem) + 1);
      } else {
        itemToCount.put(currentItem, 1);
      }
    }

    return allStrategies.stream().mapToInt(strategy -> strategy.apply(itemToCount)).sum();
  }
}


