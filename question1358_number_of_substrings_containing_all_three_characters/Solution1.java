package question1358_number_of_substrings_containing_all_three_characters;

public class Solution1 {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        // numsA[i] 表示离 s.charAt(i) 最近的字符 a 的索引
        int[] numsA = new int[n], numsB = new int[n], numsC = new int[n];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'a':
                    fill(numsA, numsB, numsC, i);
                    break;
                case 'b':
                    fill(numsB, numsA, numsC, i);
                    break;
                default:
                    fill(numsC, numsB, numsA, i);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(numsA[i], Math.min(numsB[i], numsC[i])) + 1;
        }
        return result;
    }

    private void fill(int[] nums1, int[] nums2, int[] nums3, int i) {
        nums1[i] = i;
        if (i == 0) {
            nums2[i] = -1;
            nums3[i] = -1;
        } else {
            nums2[i] = nums2[i - 1];
            nums3[i] = nums3[i - 1];
        }
    }

}