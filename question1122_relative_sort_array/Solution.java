package question1122_relative_sort_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 快排。
 *
 * 时间复杂度是O(max(n1 * log(n1), n2))，其中n1为arr1数组的长度，n2为arr2数组的长度。空间复杂度是O(n2)。
 *
 * 执行用时：5ms，击败55.04%。消耗内存：36.7MB，击败100.00%。
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        sort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
        //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (compare(nums[i], nums[left]) == 0) {
                i++;
            } else if (compare(nums[i], nums[left]) < 0) {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            } else {
                greaterThan--;
                swap(nums, greaterThan, i);
            }
        }
        //[left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        swap(nums, left, lessThan);
        lessThan--;
        sort(nums, left, lessThan);
        sort(nums, greaterThan, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int compare(int num1, int num2) {
        boolean flag1 = map.containsKey(num1), flag2 = map.containsKey(num2);
        if (flag1 && flag2) {
            return map.get(num1) - map.get(num2);
        } else if (flag1) {
            return -1;
        } else if (flag2) {
            return 1;
        }
        return num1 - num2;
    }
}
