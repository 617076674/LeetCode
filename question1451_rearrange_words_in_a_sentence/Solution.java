package question1451_rearrange_words_in_a_sentence;

import java.util.Arrays;

public class Solution {

  public String arrangeWords(String text) {
    String[] words = text.split(" ");
    words[0] = words[0].toLowerCase();
    Integer[] indexes = new Integer[words.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (index1, index2) -> {
      if (words[index1].length() == words[index2].length()) {
        return index1 - index2;
      }
      return words[index1].length() - words[index2].length();
    });
    StringBuilder sb = new StringBuilder();
    sb.append(words[indexes[0]].substring(0, 1).toUpperCase()).append(words[indexes[0]].substring(1));
    for (int i = 1; i < indexes.length; i++) {
      sb.append(" ").append(words[indexes[i]]);
    }
    return sb.toString();
  }

}