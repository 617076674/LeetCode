package question215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int result = findKthLargest(nums, 0, n - 1, k);
        return result;
    }
    /*
     * 在arr数组的[left, right]范围内寻找第k大的元素
     */
    private int findKthLargest(int[] arr, int left, int right, int k) {
        swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);
        int j = left;	//在[left + 1, j]中存储小于arr[left]的值
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] > arr[left]) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, left, j);
        if(j - left == k - 1) {
            return arr[j];
        }else if(j - left < k - 1) {
            return findKthLargest(arr, j + 1, right, k - j + left - 1);
        }else {
            return findKthLargest(arr, left, j - 1, k);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

