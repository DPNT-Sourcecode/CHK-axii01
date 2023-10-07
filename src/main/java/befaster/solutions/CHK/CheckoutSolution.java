package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
  public Integer checkout(String skus) {
    StringBuilder str = new StringBuilder(skus);

    HashMap<Character, Integer> mapPrices = new HashMap<>();
    mapPrices.put('A', 50);
    mapPrices.put('B', 30);
    mapPrices.put('C', 20);
    mapPrices.put('D', 15);

    HashMap<Character, Integer> mapCount = new HashMap<>();
    mapCount.put('A', 0);
    mapCount.put('B', 0);
    mapCount.put('C', 0);
    mapCount.put('D', 0);

    for (int i = 0; i < skus.length(); i++) {
      char current = str.charAt(i);
      if (!"ABCD".contains(String.valueOf(current))) {
        return -1;
      }
      mapCount.put(current, mapCount.get(current) + 1);
    }
    int sum = 0;

    for (Map.Entry<Character, Integer> entry : mapCount.entrySet()) {
      if (entry.getKey() == 'A') {
        if (entry.getValue() == 3) {
          sum += 130;
        } else
          sum += entry.getValue() * mapPrices.get('A');
      }

      if (entry.getKey() == 'B') {
        if (entry.getValue() == 2) {
          sum += 45;
        } else
          sum += entry.getValue() * mapPrices.get('B');
      }

      if (entry.getKey() == 'C') {
        sum += entry.getValue() * mapPrices.get('C');
      }

      if (entry.getKey() == 'D') {
        sum += entry.getValue() * mapPrices.get('D');
      }
    }

    return sum;
  }
}



