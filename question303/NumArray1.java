package question303;

public class NumArray1 {
    //sum{i]中存储[0, i - 1]的值
    private int[] sum;

    public NumArray1(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    //[i, j] = [0, j] - [0, i - 1]
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
