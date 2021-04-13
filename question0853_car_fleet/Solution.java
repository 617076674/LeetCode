package question0853_car_fleet;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  private static class Car {
    int position;
    double time;

    Car(int p, double t) {
      position = p;
      time = t;
    }
  }

  public int carFleet(int target, int[] position, int[] speed) {
    if (position.length == 0) {
      return 0;
    }
    Car[] cars = new Car[position.length];
    for (int i = 0; i < position.length; i++) {
      cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
    }
    Arrays.sort(cars, Comparator.comparingInt(a -> a.position));
    int result = 0;
    for (int i = position.length - 1; i > 0; i--) {
      if (cars[i].time < cars[i - 1].time) {
        result++;
      } else {
        cars[i - 1] = cars[i];
      }
    }
    return result + 1;
  }

}