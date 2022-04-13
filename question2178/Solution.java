package question2178;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Long> maximumEvenSplit(long finalSum) {
      List<Long> result = new ArrayList<>();
      if (finalSum % 2 == 1) {
        return result;
      }
      long cur = 2;
      while (true) {
        if (finalSum - cur <= cur) {
          result.add(finalSum);
          break;
        }
        result.add(cur);
        finalSum -= cur;
        cur += 2;
      }
      return result;
    }
    
}