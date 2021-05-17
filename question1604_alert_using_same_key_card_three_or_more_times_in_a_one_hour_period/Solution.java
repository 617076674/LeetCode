package question1604_alert_using_same_key_card_three_or_more_times_in_a_one_hour_period;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<String>> name2TimeList = new HashMap<>();
    for (int i = 0; i < keyName.length; i++) {
      List<String> list = name2TimeList.get(keyName[i]);
      if (null == list) {
        list = new ArrayList<>();
        list.add(keyTime[i]);
        name2TimeList.put(keyName[i], list);
      } else {
        list.add(keyTime[i]);
      }
    }
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : name2TimeList.entrySet()) {
      Collections.sort(entry.getValue());
      for (int i = 0; i < entry.getValue().size() - 2; i++) {
        String t1 = entry.getValue().get(i), t2 = entry.getValue().get(i + 2);
        if (getGapTime(t1, t2) <= 60) {
          result.add(entry.getKey());
          break;
        }
      }
    }
    Collections.sort(result);
    return result;
  }

  private int getGapTime(String t1, String t2) {
    int index1 = t1.indexOf(':'), index2 = t2.indexOf(':');
    int h1 = Integer.parseInt(t1.substring(0, index1));
    int h2 = Integer.parseInt(t2.substring(0, index2));
    int m1 = Integer.parseInt(t1.substring(index1 + 1));
    int m2 = Integer.parseInt(t2.substring(index2 + 1));
    return m2 - m1 + (h2 - h1) * 60;
  }

}