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


