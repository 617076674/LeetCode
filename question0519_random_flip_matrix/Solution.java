package question0519_random_flip_matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

  private Map<Integer, Integer> map = new HashMap<>();

  private int m, n, remained;

  private static Random rand = new Random();

  public Solution(int n_rows, int n_cols) {
    m = n_rows;
    n = n_cols;
    remained = m * n;
  }

  public int[] flip() {
    int random = rand.nextInt(remained--);
    int x = map.getOrDefault(random, random);
    map.put(random, map.getOrDefault(remained, remained));
    return new int[] {x / n, x % n};
  }

  public void reset() {
    map.clear();
    remained = m * n;
  }
}