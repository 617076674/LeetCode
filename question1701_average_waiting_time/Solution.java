package question1701_average_waiting_time;

public class Solution {
  
  public double averageWaitingTime(int[][] customers) {
    int now = 0;
    long waitTime = 0;
    for (int[] customer : customers) {
      if (now > customer[0]) {
        waitTime += now - customer[0];
      }
      waitTime += customer[1];
      now = Math.max(now, customer[0]) + customer[1];
    }
    return 1.0 * waitTime / customers.length;
  }

}