package question1855_maximum_distance_between_a_pair_of_values;

public class Solution {

    public int maxDistance(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0, result = 0;
        while (index1 < nums1.length) {
            while (index2 < nums2.length && nums2[index2] >= nums1[index1]) {
                index2++;
            }
            result = Math.max(result, index2 - index1 - 1);
            index1++;
        }
        return result;
    }

}