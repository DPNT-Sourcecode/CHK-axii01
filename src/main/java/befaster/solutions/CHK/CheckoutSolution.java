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

    for (Map.Entry<Character, Integer> countEntry : mapCount.entrySet()) {
      if (countEntry.getKey() == 'A') {
        if (countEntry.getValue() >= 3) {
          int offerPrice = countEntry.getValue() / 3 * 130;
          int restPrice = countEntry.getValue() % 3 * mapPrices.get('A');
          sum += offerPrice + restPrice;
        } else
          sum += countEntry.getValue() * mapPrices.get('A');
      }

      if (countEntry.getKey() == 'B') {
        if (countEntry.getValue() >= 2) {
          int offerPrice = countEntry.getValue() / 2 * 45;
          int restPrice = countEntry.getValue() % 2 * mapPrices.get('B');
          sum += offerPrice + restPrice;
        } else
          sum += countEntry.getValue() * mapPrices.get('B');
      }

      if (countEntry.getKey() == 'C') {
        sum += countEntry.getValue() * mapPrices.get('C');
      }

      if (countEntry.getKey() == 'D') {
        sum += countEntry.getValue() * mapPrices.get('D');
      }
    }

    return sum;
  }
}

