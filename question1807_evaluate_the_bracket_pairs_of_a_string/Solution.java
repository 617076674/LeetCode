package question1807_evaluate_the_bracket_pairs_of_a_string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    for (List<String> entry : knowledge) {
      map.put(entry.get(0), entry.get(1));
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        StringBuilder temp = new StringBuilder();
        int j = i;
        while (j + 1 < s.length() && s.charAt(j + 1) != ')') {
          j++;
          temp.append(s.charAt(j));
        }
        i = j + 1;
        String target = map.get(temp.toString());
        if (null == target) {
          sb.append("?");
        } else {
          sb.append(target);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}