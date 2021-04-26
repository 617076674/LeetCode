package question1333_filter_restaurants_by_vegan_friendly_price_and_distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
                                         int maxDistance) {
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < restaurants.length; i++) {
      if ((veganFriendly == 1 && restaurants[i][2] == 0) || restaurants[i][3] > maxPrice
          || restaurants[i][4] > maxDistance) {
        continue;
      }
      indexes.add(i);
    }
    Collections.sort(indexes, (index1, index2) -> {
      if (restaurants[index1][1] == restaurants[index2][1]) {
        return restaurants[index2][0] - restaurants[index1][0];
      }
      return restaurants[index2][1] - restaurants[index1][1];
    });
    List<Integer> result = new ArrayList<>();
    for (int index : indexes) {
      result.add(restaurants[index][0]);
    }
    return result;
  }

}