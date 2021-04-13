package question1007_minimum_domino_rotations_for_equal_row;

public class Solution {

    public int minDominoRotations(int[] A, int[] B) {
        int[] map = new int[7], mapA = new int[7], mapB = new int[7];
        for (int i = 0; i < A.length; i++) {
            map[A[i]]++;
            if (B[i] != A[i]) {
                map[B[i]]++;
            }
            mapA[A[i]]++;
            mapB[B[i]]++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (map[i] >= A.length) {
                result = Math.min(result, Math.min(map[i] - mapA[i], map[i] - mapB[i]));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] A = {3,5,1,2,3};
        int[] B = {3,6,3,3,4};
        System.out.println(new Solution().minDominoRotations(A, B));
    }

}