package question1414_find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int findMinFibonacciNumbers(int k) {
    List<Integer> fibonacciList = new ArrayList<>();
    fibonacciList.add(1);
    fibonacciList.add(1);
    int num1 = 1, num2 = 1;
    while (true) {
      int num = num1 + num2;
      if (num > k) {
        break;
      }
      fibonacciList.add(num);
      num1 = num2;
      num2 = num;
    }
    int index = fibonacciList.size() - 1;
    int result = 0;
    while (k > 0) {
      k -= fibonacciList.get(index);
      while (index >= 0 && fibonacciList.get(index) > k) {
        index--;
      }
      result++;
    }
    return result;
  }

}