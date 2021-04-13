package question0907_sum_of_subarray_minimums;

import java.util.Stack;

public class Solution {

  private static final int MOD = 1000000007;

  public int sumSubarrayMins(int[] arr) {
    long[] rightGreater = new long[arr.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
        rightGreater[stack.peek()] = i;
        stack.pop();
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      rightGreater[stack.pop()] = arr.length;
    }
    long[] leftGreater = new long[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
        leftGreater[stack.peek()] = i;
        stack.pop();
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      leftGreater[stack.pop()] = -1;
    }
    long result = 0;
    for (int i = 0; i < arr.length; i++) {
      result += (i - leftGreater[i]) * arr[i] % MOD * (rightGreater[i] - i) % MOD;
      result %= MOD;
    }
    return (int) result;
  }

}