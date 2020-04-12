package question1356_sort_integers_by_the_number_of_1_bits;

/**
 * 时间复杂度是O(nlogn)，其中n为arr数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：5ms，击败99.32%。消耗内存：39.9MB，击败100.00%。
 */
public class Solution {
    private int[] map = new int[10001];

    {
        for (int i = 1; i < 10001; i++) {
            map[i] = map[i >> 1] + (i & 1);
        }
    }

    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, (int) (left + Math.random() * (right - left) + 1), left);
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (arr[left] == arr[i]) {
                i++;
            } else if (map[arr[i]] < map[arr[left]] || (map[arr[i]] == map[arr[left]] && arr[i] < arr[left])) {
                lessThan++;
                swap(arr, i, lessThan);
                i++;
            } else {
                greaterThan--;
                swap(arr, i, greaterThan);
            }
        }
        swap(arr, left, lessThan);
        lessThan--;
        sort(arr, left, lessThan);
        sort(arr, greaterThan, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}