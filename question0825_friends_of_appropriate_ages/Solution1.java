package question0825_friends_of_appropriate_ages;

public class Solution1 {

  public int numFriendRequests(int[] ages) {
    int[] count = new int[121];
    for (int age : ages) {
      count[age]++;
    }
    int result = 0;
    for (int ageA = 1; ageA <= 120; ageA++) {
      int countA = count[ageA];
      for (int ageB = 1; ageB <= 120; ageB++) {
        int countB = count[ageB];
        if (ageA * 0.5 + 7 >= ageB || ageA < ageB) {
          continue;
        }
        result += countA * countB;
        if (ageA == ageB) {
          result -= countA;
        }
      }
    }
    return result;
  }

}