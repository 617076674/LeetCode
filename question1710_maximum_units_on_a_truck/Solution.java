package question1710_maximum_units_on_a_truck;

import java.util.Arrays;

public class Solution {

  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (box1, box2) -> box2[1] - box1[1]);
    int result = 0, boxes = 0;
    for (int[] box : boxTypes) {
      if (boxes + box[0] <= truckSize) {
        result += box[0] * box[1];
        boxes += box[0];
      } else {
        result += (truckSize - boxes) * box[1];
        return result;
      }
    }
    return result;
  }

}