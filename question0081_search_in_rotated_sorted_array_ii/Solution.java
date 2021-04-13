package question0081_search_in_rotated_sorted_array_ii;

/**
 * 二分法。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败98.69%。消耗内存：37.7MB，击败46.43%。
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                if (nums[mid] > nums[left]) {
                    if (target > nums[left]) {
                        //target > nums[left] && target < nums[mid] && nums[mid] > nums[left]
                        right = mid - 1;
                    } else if (target == nums[left]) {
                        return true;
                    } else {
                        //target < nums[left] && target < nums[mid] && nums[mid] > nums[left]
                        left = mid + 1;
                    }
                } else if (nums[mid] < nums[left]) {
                    //target < nums[left] && target < nums[mid] && nums[mid] < nums[left]
                    right = mid - 1;
                } else {
                    boolean flag = true;
                    for (int i = left; i <= mid; i++) {
                        if (nums[i] != nums[mid]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (nums[mid] > nums[left]) {
                    //target > nums[left] && target > nums[mid] && nums[mid] > nums[left]
                    left = mid + 1;
                } else if (nums[mid] < nums[left]) {
                    if (target > nums[left]) {
                        //target > nums[left] && target > nums[mid] && nums[mid] < nums[left]
                        right = mid - 1;
                    } else if (target == nums[left]) {
                        return true;
                    } else {
                        //target < nums[left] && target > nums[mid] && nums[mid] < nums[left]
                        left = mid + 1;
                    }
                } else {
                    boolean flag = true;
                    for (int i = left; i <= mid; i++) {
                        if (nums[i] != nums[mid]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }

}