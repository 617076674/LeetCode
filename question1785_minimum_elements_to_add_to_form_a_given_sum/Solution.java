package question1785_minimum_elements_to_add_to_form_a_given_sum;

public class Solution {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long target = Math.abs(goal - sum);
        if (target == 0) {
            return 0;
        }
        if (target % limit == 0) {
            return (int) (target / limit);
        }
        return (int) (target / limit + 1);
    }

}