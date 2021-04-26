package question1282_group_the_people_given_the_group_size_they_belong_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<Integer>> groupThePeople(int[] groupSizes) {
      Map<Integer, List<Integer>> group2Id = new HashMap<>();
      for (int i = 0; i < groupSizes.length; i++) {
          List<Integer> list = group2Id.get(groupSizes[i]);
          if (null == list) {
              list = new ArrayList<>();
              list.add(i);
              group2Id.put(groupSizes[i], list);
          } else {
              list.add(i);
          }
      }
      List<List<Integer>> result = new ArrayList<>();
      for (Map.Entry<Integer, List<Integer>> entry : group2Id.entrySet()) {
          int index = 0;
          for (int i = 0; i < entry.getValue().size() / entry.getKey(); i++) {
              List<Integer> list = new ArrayList<>();
              for (int j = index; j < index + entry.getKey(); j++) {
                  list.add(entry.getValue().get(j));
              }
              index += entry.getKey();
              result.add(list);
          }
      }
      return result;
  }

}