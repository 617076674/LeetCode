package question209;

public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;            //把[left, right]区间看作是一个滑动窗口，初始时滑动窗口中没有元素故right = -1
        int sum = 0;
        int len = nums.length + 1;        //n + 1比整个数组的长度还大，但要注意这个值其实是取不到的
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {        //当sum < s时，滑动窗口向右延伸使窗口内的值变大
                right++;
                sum += nums[right];
            } else {                                //当sum >= s时，滑动窗口left增大，使窗口向右缩进使得窗口内的值变小
                sum -= nums[left];
                left++;
            }
            if (sum >= s) {
                len = Math.min(len, right - left + 1);
            }
        }
        if (len == nums.length + 1) {
            return 0;
        } else {
            return len;
        }
    }
}
