package question1423_maximum_points_you_can_obtain_from_cards;

public class Solution2 {

  public int maxScore(int[] cardPoints, int k) {
    int sum = 0;
    for (int cardPoint : cardPoints) {
      sum += cardPoint;
    }
    int min = Integer.MAX_VALUE, left = 0, right = -1, tmp = 0;
    while (right + 1 < cardPoints.length) {
      right++;
      tmp += cardPoints[right];
      if (right - left + 1 > cardPoints.length - k) {
        tmp -= cardPoints[left];
        left++;
      }
      if (right - left + 1 == cardPoints.length - k) {
        min = Math.min(min, tmp);
      }
    }
    return sum - min;
  }

}
