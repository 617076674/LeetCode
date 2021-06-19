package question1898_maximum_number_of_removable_characters;

public class Solution {

  public int maximumRemovals(String s, String p, int[] removable) {
    int left = 0, right = removable.length;
    while (left < right) {
      if (left + 1 == right) {
        if (check(s, p, removable, right)) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (check(s, p, removable, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] removable = {3, 1, 0};
    System.out.println(new Solution().maximumRemovals("abcacb", "ab", removable));
  }

  private static boolean check(String s, String p, int[] removable, int index) {
    boolean[] removed = new boolean[s.length()];
    for (int i = 1; i <= index; i++) {
      removed[removable[i - 1]] = true;
    }
    return check(s, p, removed);
  }

  private static boolean check(String s, String p, boolean[] removed) {
    int index1 = 0, index2 = 0;
    while (index2 < p.length()) {
      char c = p.charAt(index2);
      if (index1 >= s.length()) {
        return false;
      }
      while (index1 < s.length() && (removed[index1] || s.charAt(index1) != c)) {
        index1++;
      }
      if (index1 >= s.length()) {
        return false;
      }
      if (s.charAt(index1) != c) {
        return false;
      }
      index1++;
      index2++;
    }
    return true;
  }

}