package contest.question2;

public class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int tmp = calculateFactors(num);
            if (tmp != -1) {
                result += tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(new Solution().sumFourDivisors(nums));
    }

    private int calculateFactors(int num) {
        int sum = 0, count = 0;
        for (int i = 1; i <= ((int) Math.sqrt(num)); i++) {
            if (num % i == 0) {
                sum += i + num / i;
                if (i == num / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count == 4 ? sum : -1;
    }
}