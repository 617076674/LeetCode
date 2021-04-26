package question1310_xor_queries_of_a_subarray;

import java.util.Arrays;

public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length + 1];
        for (int i = 1; i < xors.length; i++) {
            xors[i] = xors[i - 1] ^ arr[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = xors[queries[i][1] + 1] ^ xors[queries[i][0]];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(new Solution().xorQueries(arr, queries)));
    }

}