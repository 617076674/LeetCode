package question1826;

public class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
      int i = 0;
      for (; i < sensor1.length; i++) {
        if (sensor1[i] != sensor2[i]) {
          break;
        }
      }
      // 假定 sensor1 有问题
      int index1 = i, index2 = i + 1;
      while (index1 < sensor1.length && index2 < sensor2.length && sensor1[index1] == sensor2[index2]) {
        index1++;
        index2++;
      }
      boolean flag1 = index1 == sensor1.length - 1 && index2 == sensor2.length && sensor1[index1] != sensor2[i];
      // 假定 sensor2 有问题
      index1 = i + 1;
      index2 = i;
      while (index1 < sensor1.length && index2 < sensor2.length && sensor1[index1] == sensor2[index2]) {
        index1++;
        index2++;
      }
      boolean flag2 = index1 == sensor1.length && index2 == sensor2.length - 1 && sensor1[i] != sensor2[index2];
      if (flag1 && flag2) {
        return -1;
      }
      if (!flag1 && !flag2) {
        return -1;
      }
      if (flag1) {
        return 1;
      }
      return 2;
    }

}