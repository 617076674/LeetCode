package question0658_find_k_closest_elements;

import java.util.LinkedList;
import java.util.List;

/**
 * 双指针。
 *
 * 时间复杂度是O(max(k, logn))，其中n为arr数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败60.21%。消耗内存：39.6MB，击败95.74%。
 */
public class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
        } else if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i <= arr.length - 1; i++) {
                result.add(arr[i]);
            }
        } else {
            int index = findCloestIndex(arr, x);
            result.add(arr[index]);
            int left = index - 1, right = index + 1;
            while (result.size() < k) {
                if (left < 0) {
                    result.add(arr[right]);
                    right++;
                } else if (right >= arr.length) {
                    result.add(0, arr[left]);
                    left--;
                } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            }
        }
        return result;
    }

    private int findCloestIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1, result = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == x) {
                return mid;
            } else {
                if (Math.abs(arr[mid] - x) < Math.abs(arr[result] - x)) {
                    result = mid;
                }
                if (arr[mid] > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
}