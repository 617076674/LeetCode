package question0525_contiguous_array;

public class Solution1 {

    public int findMaxLength(int[] nums) {
        int[] countOne = new int[nums.length + 1];
        for (int i = 1; i < countOne.length; i++) {
            countOne[i] = countOne[i - 1];
            if (nums[i - 1] == 1) {
                countOne[i]++;
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            if (((j - i + 1) & 1) == 1) {
                j--;
            }
            for (; j >= result + i + 1; j -= 2) {
                if ((j - i + 1) == 2 * (countOne[j + 1] - countOne[i])) {
                    result = Math.max(result, j - i + 1);
                    break;
                }
            }
        }
        return result;
    }

}