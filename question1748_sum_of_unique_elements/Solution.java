package question1748_sum_of_unique_elements;

public class Solution {

    public int sumOfUnique(int[] nums) {
        int[] map = new int[101];
        for (int num : nums) {
            map[num]++;
        }
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                result += i;
            }
        }
        return result;
    }

}