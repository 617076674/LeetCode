package question2060_check_if_an_original_string_exists_given_two_encoded_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {

  private Map<Long, Boolean> memo = new HashMap<>();

  public boolean possiblyEquals(String s1, String s2) {
    return possiblyEqualsHelper(str2List(s1), 0, 0, str2List(s2), 0, 0);
  }

  private boolean possiblyEqualsHelper(List<String> list1, int index1, int num1,
                                       List<String> list2, int index2, int num2) {
    if (index1 == list1.size() && index2 == list2.size()) {
      return num1 == num2;
    }
    if ((index1 == list1.size() && num1 == 0) || (index2 == list2.size() && num2 == 0)) {
      return false;
    }
    long hash = index1 * 10000000000L + num1 * 1000000L + index2 * 100L + num2;
    Boolean result = memo.get(hash);
    if (null != result) {
      return result;
    }
    if (index1 < list1.size() && Character.isDigit(list1.get(index1).charAt(0))) {
      for (int num : str2Set(list1.get(index1))) {
        if (possiblyEqualsHelper(list1, index1 + 1, num1 + num, list2, index2, num2)) {
          memo.put(hash, true);
          return true;
        }
      }
      memo.put(hash, false);
      return false;
    }
    if (index2 < list2.size() && Character.isDigit(list2.get(index2).charAt(0))) {
      for (int num : str2Set(list2.get(index2))) {
        if (possiblyEqualsHelper(list1, index1, num1, list2, index2 + 1, num2 + num)) {
          memo.put(hash, true);
          return true;
        }
      }
      memo.put(hash, false);
      return false;
    }
    if (num1 > 0 && num2 > 0) {
      int min = Math.min(num1, num2);
      return possiblyEqualsHelper(list1, index1, num1 - min, list2, index2, num2 - min);
    }
    if (num1 > 0 && num2 == 0) {
      return possiblyEqualsHelper(list1, index1, num1 - 1, list2, index2 + 1, 0);
    }
    if (num1 == 0 && num2 > 0) {
      return possiblyEqualsHelper(list1, index1 + 1, 0, list2, index2, num2 - 1);
    }
    if (Objects.equals(list1.get(index1), list2.get(index2))) {
      return possiblyEqualsHelper(list1, index1 + 1, 0, list2, index2 + 1, 0);
    }
    memo.put(hash, false);
    return false;
  }

  private static Set<Integer> str2Set(String s) {
    int num = Integer.parseInt(s);
    Set<Integer> result = new HashSet<>();
    result.add(num);
    if (s.length() == 2) {
      int a = num / 10, b = num % 10;
      result.add(a + b);
    } else if (s.length() == 3) {
      int a = num / 100, b = (num % 100) / 10, c = num % 10;
      result.add(a + b * 10 + c);
      result.add(a + b + c);
      result.add(a * 10 + b + c);
    }
    return result;
  }

  private static List<String> str2List(String s) {
    List<String> result = new ArrayList<>(40);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int j = i;
        while (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1))) {
          j++;
        }
        result.add(s.substring(i, j + 1));
        i = j;
      } else {
        result.add(s.substring(i, i + 1));
      }
    }
    return result;
  }

}