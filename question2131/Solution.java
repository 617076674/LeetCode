package question2131;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    int result = 0;
    boolean hasSame = false;
    for (String word : words) {
      if (word.charAt(0) == word.charAt(1)) {
        int count = map.get(word);
        if (count % 2 == 0) {
          result += count * 2;
        } else {
          result += (count - 1) * 2;
          hasSame = true;
        }
        map.put(word, 0);
      } else {
        String reverseWord = "" + word.charAt(1) + word.charAt(0);
        int num1 = map.get(word);
        Integer num2 = map.get(reverseWord);
        if (null != num2) {
          int num = Math.min(num1, num2);
          result += num * 4;
          map.put(word, num1 - num);
          map.put(reverseWord, num2 - num);
        }
      }
    }
    if (hasSame) {
      return 2 + result;
    }
    return result;
  }

}