package question1209_remove_all_adjacent_duplicates_in_string_ii;

import java.util.LinkedList;

public class Solution {

  public String removeDuplicates(String s, int k) {
    LinkedList<Character> charList = new LinkedList<>();
    LinkedList<Integer> countList = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charList.isEmpty() || charList.peekLast() != c) {
        charList.addLast(c);
        countList.addLast(1);
      } else {
        countList.addLast(countList.pollLast() + 1);
        if (countList.peekLast() == k) {
          charList.pollLast();
          countList.pollLast();
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!charList.isEmpty()) {
      char c = charList.pollFirst();
      int count = countList.pollFirst();
      for (int i = 0; i < count; i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
  }

}