package question2114;

public class Solution {

  public int mostWordsFound(String[] sentences) {
    int result = 0;
    for (String sentence : sentences) {
      int temp = 0;
      for (int i = 0; i < sentence.length(); i++) {
        if (sentence.charAt(i) == ' ') {
          temp++;
        }
      }
      result = Math.max(result, temp + 1);
    }
    return result;
  }

}