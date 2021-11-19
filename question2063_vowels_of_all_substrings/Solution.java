package question2063_vowels_of_all_substrings;

public class Solution {

  public long countVowels(String word) {
    long result = 0L;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        result += (i + 1L) * (word.length() - i);
      }
    }
    return result;
  }

}