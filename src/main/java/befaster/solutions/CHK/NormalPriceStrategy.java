package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class NormalPriceStrategy implements Strategy {
  private static final HashMap<String, Integer> itemToPrice = new HashMap<>();

  static {
    itemToPrice.put("A", 50);
    itemToPrice.put("B", 30);
    itemToPrice.put("C", 20);
    itemToPrice.put("D", 15);
    itemToPrice.put("E", 40);
    itemToPrice.put("F", 10);
    itemToPrice.put("G", 20);
    itemToPrice.put("H", 10);
    itemToPrice.put("I", 35);
    itemToPrice.put("J", 60);
    itemToPrice.put("K", 80);
    itemToPrice.put("L", 90);
    itemToPrice.put("M", 15);
    itemToPrice.put("N", 40);
    itemToPrice.put("O", 10);
    itemToPrice.put("P", 50);
    itemToPrice.put("Q", 30);
    itemToPrice.put("R", 50);
    itemToPrice.put("S", 30);
    itemToPrice.put("T", 20);
    itemToPrice.put("U", 40);
    itemToPrice.put("V", 50);
    itemToPrice.put("W", 20);
    itemToPrice.put("X", 90);
    itemToPrice.put("Y", 10);
    itemToPrice.put("Z", 50);
  }

  @Override public int apply(HashMap<String, Integer> itemToCount) {
    int sum = 0;
    for (Map.Entry<String, Integer> entry : itemToCount.entrySet()) {
      String itemName = entry.getKey();
      int count = entry.getValue();
      sum += itemToPrice.get(itemName) * count;
    }
    return sum;
  }
}
