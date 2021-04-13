package contest_3_20.question2;

public class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (findTheWinner(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(5, 2));
        System.out.println(new Solution().findTheWinner(6, 5));
    }
}