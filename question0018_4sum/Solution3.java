package question0018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 *
 * 和question0015的Solution3、question0016的Solution2同样的思路，内层循环采用双指针遍历的形式。
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：54ms，击败73.50%。消耗内存：40.3MB，击败77.12%。
 */
public class Solution3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return listList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {   //这个判断很重要，不然会很慢
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 1] > target) {   //这个判断很重要，不然会很慢
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        addToListList(nums[i], nums[j], nums[left], nums[right], listList);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, int num4, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        listList.add(list);
    }
}