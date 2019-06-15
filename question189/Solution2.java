package question189;

/**
 * 对于[1, 2, 3, 4, 5, 6, 7]，其右移3位的结果是[5, 6, 7, 1, 2, 3, 4]。
 *
 * 可以经过下面几个步骤得到：
 *
 * （1）反转原数组，得到[7, 6, 5, 4, 3, 2, 1]。
 *
 * （2）反转[0, 2]范围内的元素，得到[5, 6, 7, 4, 3, 2, 1]。
 *
 * （3）反转[3, 6]范围内的元素，得到[5, 6, 7, 1, 2, 3, 4]。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败57.35%。消耗内存：39.6MB，击败29.37%。
 */
public class Solution2 {

    public void rotate(int[] nums, int k) {
        if(0 == nums.length){
            return;
        }
        k %= nums.length;
        if(0 == k){
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right){
        int i = left, j = right;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
