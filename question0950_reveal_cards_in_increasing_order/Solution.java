package question0950_reveal_cards_in_increasing_order;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public int[] deckRevealedIncreasing(int[] deck) {
    int N = deck.length;
    Deque<Integer> index = new LinkedList<>();
    for (int i = 0; i < N; ++i) {
      index.add(i);
    }
    int[] result = new int[N];
    Arrays.sort(deck);
    for (int card : deck) {
      result[index.pollFirst()] = card;
      if (!index.isEmpty()) {
        index.add(index.pollFirst());
      }
    }
    return result;
  }

}