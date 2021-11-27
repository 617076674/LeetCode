package question2079_watering_plants;

public class Solution {

  public int wateringPlants(int[] plants, int capacity) {
    int result = 0, water = capacity;
    for (int i = -1; i < plants.length - 1; i++) {
      if (water < plants[i + 1]) {
        water = capacity;
        result += (i + 1) * 2;
        i--;
      } else {
        water -= plants[i + 1];
        result++;
      }
    }
    return result;
  }

}