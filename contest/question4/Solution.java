package contest.question4;

public class Solution {
    public int numOfArrays(int n, int m, int k) {
        if (n <= k || m < k) {
            return 0;
        }
        long result = 0;
        for (int i = 1; i <= m; i++) {
            result += (Math.pow(i - 1, k - 1) % 1000000007) * (Math.pow(i, n - k) % 1000000007) % 1000000007;
            result %= 1000000007;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfArrays(2, 3, 1));
        System.out.println(new Solution().numOfArrays(5, 2, 3));
        System.out.println(new Solution().numOfArrays(9, 1, 1));
        System.out.println(new Solution().numOfArrays(50, 100, 25));
        System.out.println(new Solution().numOfArrays(37, 17, 7));
    }
}