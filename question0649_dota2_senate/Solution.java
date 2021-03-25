package question0649_dota2_senate;

import java.util.LinkedList;

public class Solution {

  public String predictPartyVictory(String senate) {
    int n = senate.length();
    LinkedList<Integer> radiant = new LinkedList<>(), dire = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') {
        radiant.addLast(i);
      } else {
        dire.addLast(i);
      }
    }
    while (!radiant.isEmpty() && !dire.isEmpty()) {
      int radiantIndex = radiant.pollFirst(), direIndex = dire.pollFirst();
      if (radiantIndex < direIndex) {
        radiant.addLast(radiantIndex + n);
      } else {
        dire.addLast(direIndex + n);
      }
    }
    return radiant.isEmpty() ? "Dire" : "Radiant";
  }

}