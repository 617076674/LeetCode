package lcof40_zui_xiao_de_kge_shu;

public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (Math.random() * (right - left) + left + 1));
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] > nums[left]) {
                greaterThan--;
                swap(nums, i, greaterThan);
            } else {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        if (greaterThan - left < k) {
            quickSort(nums, greaterThan, right, k - greaterThan + left);
        } else if (k < lessThan - left + 1) {
            quickSort(nums, left, lessThan, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}