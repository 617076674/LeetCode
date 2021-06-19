package lcs02_WqXACV;

import java.util.Arrays;

public class Solution {

  public int halfQuestions(int[] questions) {
    int[] count = new int[1001];
    for (int question : questions) {
      count[question]++;
    }
    Arrays.sort(count);
    int index = count.length - 1, n = questions.length / 2;
    while (n > 0) {
      n -= count[index--];
    }
    return count.length - index - 1;
  }

}