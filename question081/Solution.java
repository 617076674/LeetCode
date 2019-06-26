package question081;

/**
 * 二分法。
 * <p>
 * 时间复杂度是O(nlogn)。空间复杂度是O(1)。
 * <p>
 * 执行用时：2ms，击败96.98%。消耗内存：36.4MB，击败75.30%。
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[left]) {
                return true;
            } else if (target < nums[left]) {
                if (target == nums[mid]) {
                    return true;
                } else if (target < nums[mid]) {
                    //target < nums[mid] && target < nums[left]
                    //接下来我们的寻找范围是哪里呢？是[left, mid - 1]，还是[mid + 1, right]呢？
                    //假如[left, mid]中的元素均相等，我们的寻找范围就是[mid + 1, right]。
                    //否则，我们的寻找范围就是[left, mid - 1]。
                    int[] leftRight = search(nums, left, mid, right);
                    left = leftRight[0];
                    right = leftRight[1];
                } else {
                    left = mid + 1;
                }
            } else {
                if (target == nums[mid]) {
                    return true;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    int[] leftRight = search(nums, left, mid, right);
                    left = leftRight[0];
                    right = leftRight[1];
                }
            }
        }
        return false;
    }

    /**
     * 当target < nums[mid] && target < nums[left]或target > nums[left] && target > nums[mid]时，
     * 我们下一步查找的范围是什么呢？
     * <p>
     * 这就是这个函数的作用。
     */
    private int[] search(int[] nums, int left, int mid, int right) {
        if (nums[mid] > nums[left]) {
            left = mid + 1;
        } else if (nums[mid] < nums[left]) {
            right = mid - 1;
        } else {
            int i = left;
            for (; i <= mid; i++) {
                if (nums[i] != nums[mid]) {
                    break;
                }
            }
            if (i <= mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int[] result = new int[2];
        result[0] = left;
        result[1] = right;
        return result;
    }

}
