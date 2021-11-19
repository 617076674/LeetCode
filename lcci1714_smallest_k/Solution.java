package lcci1714_smallest_k;

import java.util.Arrays;

public class Solution {

    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        System.out.println(Arrays.toString(new Solution().smallestK(arr, k)));
    }

    /**
     * 在 arr 数组 [left, right] 范围内选取出最小的 k 个数
     */
    private void quickSort(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        swap(arr, left, (int) (Math.random() * (right - left) + left + 1));
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        while (i < greaterThan) {
            if (arr[i] == arr[left]) {
                i++;
            } else if (arr[i] < arr[left]) {
                lessThan++;
                swap(arr, i, lessThan);
                i++;
            } else {
                greaterThan--;
                swap(arr, i, greaterThan);
            }
        }
        // [left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        swap(arr, left, lessThan);
        lessThan--;
        // [left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        if (greaterThan - left < k) {
            quickSort(arr, greaterThan, right, k - greaterThan + left);
        } else if (lessThan + 1 - left > k) {
            quickSort(arr, left, lessThan, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}