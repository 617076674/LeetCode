package question1452_people_whose_list_of_favorite_companies_is_not_a_subset_of_another_list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Integer> result = new ArrayList<>();
    int n = favoriteCompanies.size();
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if (i != j && new HashSet<>(favoriteCompanies.get(j)).containsAll(favoriteCompanies.get(i))) {
          flag = false;
          break;
        }
      }
      if (flag) {
        result.add(i);
      }
    }
    return result;
  }

}