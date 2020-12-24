package lcof51_shu_zu_zhong_de_ni_xu_dui;

public class Solution1 {
    private int result;

    public int reversePairs(int[] nums) {
        for (int sz = 1; sz < nums.length; sz *= 2) {
            for (int i = 0; i < nums.length - sz; i += 2 * sz) {
                merge(nums, i, i + sz - 1, Math.min(i + 2 * sz - 1, nums.length - 1));
            }
        }
        return result;
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = array[i];
        }
        int index1 = mid, index2 = right;
        for (int i = right; i >= left; i--) {
            if (index1 < left) {
                array[i] = aux[index2 - left];
                index2--;
            } else if (index2 <= mid) {
                array[i] = aux[index1 - left];
                index1--;
            } else if (aux[index1 - left] > aux[index2 - left]) {
                result += index2 - mid;
                array[i] = aux[index1 - left];
                index1--;
            } else {
                array[i] = aux[index2 - left];
                index2--;
            }
        }
    }
}