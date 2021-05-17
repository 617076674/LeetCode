package question1415_the_k_th_lexicographical_string_of_all_happy_strings_of_length_n;

public class Solution {

  public String getHappyString(int n, int k) {
    int total = (int) (3 * Math.pow(2, n - 1));
    if (k > total) {
      return "";
    }
    return getHappyString(n, k, 'd');
  }

  public String getHappyString(int n, int k, char pre) {
    if (n == 1) {
      if (pre == 'd' || pre == 'c') {
        return "" + (char) ('a' + k - 1);
      }
      if (pre == 'a') {
        return "" + (char) ('b' + k - 1);
      }
      return k == 1 ? "a" : "c";
    }
    if (pre == 'd') {
      int total = (int) (3 * Math.pow(2, n - 1));
      if (k <= total / 3) {
        return "a" + getHappyString(n - 1, k, 'a');
      }
      if (k <= 2 * total / 3) {
        return "b" + getHappyString(n - 1, k - total / 3, 'b');
      }
      return "c" + getHappyString(n - 1, k - 2 * total / 3, 'c');
    }
    if (pre == 'a') {
      int total = (int) Math.pow(2, n);
      if (k <= total / 2) {
        return "b" + getHappyString(n - 1, k, 'b');
      }
      return "c" + getHappyString(n - 1, k - total / 2, 'c');
    }
    if (pre == 'b') {
      int total = (int) Math.pow(2, n);
      if (k <= total / 2) {
        return "a" + getHappyString(n - 1, k, 'a');
      }
      return "c" + getHappyString(n - 1, k - total / 2, 'c');
    }
    int total = (int) Math.pow(2, n);
    if (k <= total / 2) {
      return "a" + getHappyString(n - 1, k, 'a');
    }
    return "b" + getHappyString(n - 1, k - total / 2, 'b');
  }

}