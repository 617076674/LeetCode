package lcof21_diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian;

public class Solution {

    public int[] exchange(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (Math.random() * (right - left + 1) + left));
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (compare(nums[i], nums[left]) == 0) {
                i++;
            } else if (compare(nums[i], nums[left]) > 0) {
                greaterThan--;
                swap(nums, i, greaterThan);
            } else {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            }
        }
        // [left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        swap(nums, left, lessThan);
        lessThan--;
        // [left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        quickSort(nums, left, lessThan);
        quickSort(nums, greaterThan, right);
    }

    private int compare(int i, int j) {
        int tmp1 = i & 1, tmp2 = j & 1;
        return tmp1 == 1 ? (tmp2 == 1 ? 0 : -1) : (tmp2 == 0 ? 0 : 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}