package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {

  private static final FreeItemStrategy freeItemStrategy1 = new FreeItemStrategy("E", 2, "B");
  private static final FreeItemStrategy freeItemStrategy2 = new FreeItemStrategy("N", 3, "M");
  private static final FreeItemStrategy freeItemStrategy3 = new FreeItemStrategy("R", 3, "Q");

//  private static final DiscountStrategy discountStrategy1 = new DiscountStrategy("A", 5, 200)
//  private static final DiscountStrategy discountStrategy2 = new DiscountStrategy("A", 3, 130)
//  private static final DiscountStrategy discountStrategy3 = new DiscountStrategy("B", 2, 45)
//  private static final DiscountStrategy discountStrategy4 = new DiscountStrategy("F", 3, 20)
//  private static final DiscountStrategy discountStrategy5 = new DiscountStrategy("U", 3, 80)
  private static final List<Strategy> allStrategies = List.of(
      new FreeItemStrategy("E", 2, "B"),
      new FreeItemStrategy("N", 3, "M"),
      new FreeItemStrategy("R", 3, "Q"),
      new DiscountStrategy("A", 5, 200),
      new DiscountStrategy("A", 3, 130),
      new DiscountStrategy("B", 2, 45),
      new DiscountStrategy("F", 3, 20),
      new DiscountStrategy("U", 3, 80),
      new DiscountStrategy("H", 5, 45),
      new DiscountStrategy("H", 10, 80),
      new DiscountStrategy("K", 2, 150),
      new DiscountStrategy("P", 5, 200),
      new DiscountStrategy("Q", 3, 80),
      new DiscountStrategy("V", 3, 130),
      new DiscountStrategy("V", 2, 90),
      new NormalPriceStrategy());

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



