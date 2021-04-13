package contest_3_20.question1;

public class Solution {
    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative++;
            }
        }
        return (negative & 1) == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,3,2,1};
        System.out.println(new Solution().arraySign(nums));
    }
}