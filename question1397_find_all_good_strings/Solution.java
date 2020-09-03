package question1397_find_all_good_strings;

public class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int result = 0, mod = 1000000007;
        for (String s = s1; s.compareTo(s2) <= 0; s = nextString(s)) {
            if (!s.contains(evil)) {
                result++;
            }
            result %= mod;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findGoodStrings(2, "aa", "da", "b"));
    }

    private String nextString(String s) {
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (flag + c - 'a' >= 26) {
                sb.append((char) (flag + c - 26));
                flag = 1;
            } else {
                sb.append((char) (flag + c));
                flag = 0;
            }
        }
        return sb.reverse().toString();
    }
}