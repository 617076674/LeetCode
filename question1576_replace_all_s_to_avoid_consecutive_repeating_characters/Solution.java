package question1576_replace_all_s_to_avoid_consecutive_repeating_characters;

public class Solution {

  public String modifyString(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '?') {
        char before = i == 0 ? ' ' : chars[i - 1];
        char behind = i == chars.length - 1 ? ' ' : chars[i + 1];
        char temp = 'a';
        while (temp == before || temp == behind) {
          temp++;
        }
        chars[i] = temp;
      }
    }
    return new String(chars);
  }

}