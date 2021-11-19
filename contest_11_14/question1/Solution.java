package contest_11_14.question1;

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

  public static void main(String[] args) {
    int[] tickets = {5,1,1,1};
    int k = 0;
    System.out.println(new Solution().timeRequiredToBuy(tickets, k));
  }

}