package question2197;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> replaceNonCoprimes(int[] nums) {
    LinkedList<Long> stack = new LinkedList<>();
    for (int num : nums) {
      long temp = num;
      while (!stack.isEmpty() && gcd(stack.peekLast(), temp) > 1) {
        long another = stack.pollLast();
        long lcm = another * temp / gcd(another, temp);
        temp = lcm;
      }
      stack.addLast(temp);
    }
    List<Integer> result = new ArrayList<>();
    for (long num : stack) {
      result.add((int) num);
    }
    return result;
  }

  private static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

}