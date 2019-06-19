package question0321;

/**
 * @author qianyihui
 * @date 2019-06-18
 */
public class Solution {
    /**
     * 假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
     * 组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
     * Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n2); i <= k && i <= n1; i++) {
            //在nums1数组中取i个元素，在nums2数组中取k - i个元素
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)) {
                res = arr;
            }
        }
        return res;
    }

    /*
    假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3];
    n - i : 当前数组中,当前下标到结尾还有多少个元素;
    j : 当前数组中i之前有多少个数加入到最大组合中;
    n - i + j > k <=> n - i - 1 + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--,
    n - i(数组剩余元素) - 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k;
    if j < k : 先将最大组合填满再进行比较替换操作
     */
    private int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    /*
    假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
     */
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            if (gt(nums1, i, nums2, j)) {
                res[r] = nums1[i++];
            } else {
                res[r] = nums2[j++];
            }
        }
        return res;
    }

    /**
     * 比较两数组相应位置大小,相等就一直跳过,直到不相等就比较。
     */
    private boolean gt(int[] nums1, int i, int[] nums2, int j) {
        int n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2 && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n2 || (i < n1 && nums1[i] > nums2[j]);
    }
}
