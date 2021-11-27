package question2073_time_needed_to_buy_tickets;

import java.util.LinkedList;

public class Solution {

  public int timeRequiredToBuy(int[] tickets, int k) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < tickets.length; i++) {
      list.add(i);
    }
    int result = 0;
    while (true) {
      result++;
      int index = list.removeFirst();
      tickets[index]--;
      if (tickets[index] == 0 && k == index) {
        return result;
      }
      if (tickets[index] > 0) {
        list.addLast(index);
      }
    }
  }

}