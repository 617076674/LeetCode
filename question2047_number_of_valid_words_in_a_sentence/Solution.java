package question2047_number_of_valid_words_in_a_sentence;

public class Solution {

  public int countValidWords(String sentence) {
    int result = 0;
    String[] words = sentence.split("\\s+");
    for (String word : words) {
      if (check(word)) {
        result++;
      }
    }
    return result;
  }

  private static boolean check(String word) {
    if (word.trim().isEmpty()) {
      return false;
    }
    int countConnect = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c != '-' && c != '/' && !isLowerLetter(c) && !isPunctuation(c)) {
        return false;
      }
      if (c == '-') {
        countConnect++;
        if (countConnect > 1) {
          return false;
        }
        if (i - 1 < 0 || i + 1 >= word.length()) {
          return false;
        }
        if (!isLowerLetter(word.charAt(i - 1)) || !isLowerLetter(word.charAt(i + 1))) {
          return false;
        }
      }
      if (isPunctuation(c)) {
        if (i != word.length() - 1) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isLowerLetter(char c) {
    return c >= 'a' && c <= 'z';
  }

  private static boolean isPunctuation(char c) {
    return c == '!' || c == '.' || c == ',';
  }

}