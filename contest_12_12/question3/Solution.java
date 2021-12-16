package contest_12_12.question3;

public class Solution {

  public int minimumRefill(int[] plants, int capacityA, int capacityB) {
    int result = 0;
    int alice = 0, bob = plants.length - 1;
    int aliceWater = capacityA, bobWater = capacityB;
    while (alice < bob) {
      if (aliceWater < plants[alice]) {
        result++;
        aliceWater = capacityA - plants[alice];
      } else {
        aliceWater -= plants[alice];
      }
      alice++;
      if (bobWater < plants[bob]) {
        result++;
        bobWater = capacityB - plants[bob];
      } else {
        bobWater -= plants[bob];
      }
      bob--;
    }
    if (alice == bob) {
      if (aliceWater > bobWater || (aliceWater == bobWater)) {
        if (aliceWater < plants[alice]) {
          result++;
        }
      } else  {
        if (bobWater < plants[alice]) {
          result++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] plants = {7,7,7,7,7,7,7};
    int capacityA = 7;
    int capacityB = 8;
    System.out.println(new Solution().minimumRefill(plants, capacityA, capacityB));
  }

}
