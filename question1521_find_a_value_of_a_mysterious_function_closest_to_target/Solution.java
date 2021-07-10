package question1521_find_a_value_of_a_mysterious_function_closest_to_target;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int closestToTarget(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        List<Integer> valid = new ArrayList<>();
        valid.add(arr[0]);
        for (int num : arr) {
            List<Integer> validNew = new ArrayList<>();
            validNew.add(num);
            int last = num;
            ans = Math.min(ans, Math.abs(num - target));
            for (int prev : valid) {
                int curr = prev & num;
                if (curr != last) {
                    validNew.add(curr);
                    ans = Math.min(ans, Math.abs(curr - target));
                    last = curr;
                }
            }
            valid = validNew;
        }
        return ans;
    }

}