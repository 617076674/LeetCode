package question1299_replace_elements_with_greatest_element_on_right_side;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n是数组arr的长度。
 *
 * 执行用时：2ms，击败69.74%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int n;
        if (null == arr || (n = arr.length) == 0) {
            return arr;
        }
        if (n == 1) {
            return new int[] {-1};
        }
        int[] rightMax = new int[n];
        rightMax[n - 2] = arr[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i + 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            arr[i] = rightMax[i];
        }
        arr[n - 1] = -1;
        return arr;
    }
}