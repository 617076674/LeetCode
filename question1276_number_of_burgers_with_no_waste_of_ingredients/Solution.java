package question1276_number_of_burgers_with_no_waste_of_ingredients;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
    List<Integer> result = new ArrayList<>();
    int temp = (tomatoSlices - 2 * cheeseSlices);
    if (temp < 0 || (temp & 1) == 1) {
      return result;
    }
    int totalJumbo = temp >> 1, totalSmall = cheeseSlices - totalJumbo;
    if (totalSmall < 0) {
        return result;
    }
    result.add(totalJumbo);
    result.add(totalSmall);
    return result;
  }

}