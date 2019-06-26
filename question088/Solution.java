package question088;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83044403
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int cur1 = 0;
        int cur2 = 0;
        int cur = 0;
        while (cur1 < m || cur2 < n) {
            if (cur1 >= m) {
                nums1[cur] = nums2[cur2];
                cur2++;
                cur++;
            } else if (cur2 >= n) {
                nums1[cur] = temp[cur1];
                cur1++;
                cur++;
            } else if (temp[cur1] > nums2[cur2]) {
                nums1[cur] = nums2[cur2];
                cur2++;
                cur++;
            } else {
                nums1[cur] = temp[cur1];
                cur1++;
                cur++;
            }
        }
    }
}
