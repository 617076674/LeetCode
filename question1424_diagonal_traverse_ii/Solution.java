package question1424_diagonal_traverse_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<List<Integer>> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        while (list.size() <= i + j) {
          list.add(new ArrayList<>());
        }
        list.get(i + j).add(nums.get(i).get(j));
      }
      count += nums.get(i).size();
    }
    int[] result = new int[count];
    int index = 0;
    for (List<Integer> temp : list) {
      for (int j = temp.size() - 1; j >= 0; j--) {
        result[index++] = temp.get(j);
      }
    }
    return result;
  }

}