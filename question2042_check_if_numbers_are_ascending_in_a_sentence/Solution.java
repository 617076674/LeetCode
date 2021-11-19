package question2042_check_if_numbers_are_ascending_in_a_sentence;

public class Solution {

    public boolean areNumbersAscending(String s) {
      String[] words = s.split(" ");
      int pre = -1;
      for (String word : words) {
        try {
          int num = Integer.parseInt(word);
          if (num <= pre) {
            return false;
          }
          pre = num;
        } catch (Exception e) {

        }
      }
      return true;
    }

}