package question2008_maximum_earnings_from_taxi;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static class Passenger {

    int start, end, tip;

    public Passenger(int start, int end, int tip) {
      this.start = start;
      this.end = end;
      this.tip = tip;
    }

  }

  private List<Passenger>[] passengerList;

  private int n;

  private Long[] memo;

  public long maxTaxiEarnings(int n, int[][] rides) {
    passengerList = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      passengerList[i] = new ArrayList<>();
    }
    for (int[] ride : rides) {
      passengerList[ride[0]].add(new Passenger(ride[0], ride[1], ride[2]));
    }
    this.n = n;
    memo = new Long[n + 1];
    return maxTaxiEarnings(1);
  }

  private long maxTaxiEarnings(int cur) {
    if (cur > n) {
      return 0;
    }
    if (memo[cur] != null) {
      return memo[cur];
    }
    long result = 0;
    for (Passenger passenger : passengerList[cur]) {
      result = Math.max(result, passenger.end - passenger.start + passenger.tip + maxTaxiEarnings(passenger.end));
    }
    result = Math.max(result, maxTaxiEarnings(cur + 1));
    memo[cur] = result;
    return result;
  }

}