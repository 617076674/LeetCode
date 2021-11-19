package question2024_maximize_the_confusion_of_an_exam;

public class Solution {

  public int maxConsecutiveAnswers(String answerKey, int k) {
    return Math.max(maxConsecutiveAnswers(answerKey, k, 'F'),
        maxConsecutiveAnswers(answerKey, k, 'T'));
  }

  private static int maxConsecutiveAnswers(String answerKey, int k, char c) {
    int left = 0, right = -1, needChanged = 0, result = 0;
    while (right + 1 < answerKey.length()) {
      right++;
      if (answerKey.charAt(right) == c) {
        needChanged++;
      }
      while (needChanged > k) {
        if (answerKey.charAt(left) == c) {
          needChanged--;
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

}