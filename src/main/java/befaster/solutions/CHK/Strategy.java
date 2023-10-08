package befaster.solutions.CHK;

import java.util.HashMap;

public interface Strategy {
  int apply(HashMap<String, Integer> itemToCount);
}
