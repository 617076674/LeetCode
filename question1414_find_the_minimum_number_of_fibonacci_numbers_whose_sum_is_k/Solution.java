package question1414_find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private List<Integer> list = new ArrayList<>();

    private Map<Integer, Integer> memo = new HashMap<>();

    public int findMinFibonacciNumbers(int k) {
        list.add(1);
        int num1 = 1, num2 = 1, num;
        while ((num = num1 + num2) <= k) {
            list.add(num);
            num1 = num2;
            num2 = num;
        }
        int result = findMinFibonacciNumbersHelper(k);
        return result;
    }

    private int floor(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (list.get(mid) == target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < list.size() && list.get(left) == target) {
            return left;
        }
        return right;
    }

    private int findMinFibonacciNumbersHelper(int k) {
        if (k == 0) {
            return 0;
        }
        Integer result = memo.get(k);
        if (null != result) {
            return result;
        }
        int index = floor(list, k);
        result = 1 + findMinFibonacciNumbersHelper(k - list.get(index));
        memo.put(k, result);
        return result;
    }

}