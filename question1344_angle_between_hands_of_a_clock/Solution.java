package question1344_angle_between_hands_of_a_clock;

public class Solution {

  public double angleClock(int hour, int minutes) {
    int time = hour * 60 + minutes;
    double angle1 = time * 360 / 60.0, angle2 = time * 360 / 60.0 / 12;
    double angle;
    if (angle1 > angle2) {
      angle = angle1 - angle2 - (int) ((angle1 - angle2) / 360) * 360;
    } else {
      angle = angle2 - angle1 - (int) ((angle2 - angle1) / 360) * 360;
    }
    return Math.min(angle, 360 - angle);
  }

}