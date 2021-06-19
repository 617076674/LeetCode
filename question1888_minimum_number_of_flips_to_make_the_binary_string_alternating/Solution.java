package question1888_minimum_number_of_flips_to_make_the_binary_string_alternating;

public class Solution {

    public int minFlips(String s) {
        int[][] pre = new int[s.length()][2], suf = new int[s.length() + 1][2];
        // pre[i][j] 代表将字符串 s 中 [0, i] 范围内的子串变成以 j 结尾所需操作2的次数
        // sif[i][j] 代表将字符串 s 中 [i, s.length - 1] 范围内的子串变成以 j 开头所需操作2的次数
        if (s.charAt(0) == '1') {
            pre[0][0] = 1;
        } else {
            pre[0][1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                pre[i][0] = pre[i - 1][1];
                pre[i][1] = pre[i - 1][0] + 1;
            } else {
                pre[i][0] = pre[i - 1][1] + 1;
                pre[i][1] = pre[i - 1][0];
            }
        }
        if (s.charAt(s.length() - 1) == '1') {
            suf[s.length() - 1][0] = 1;
        } else {
            suf[s.length() - 1][1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                suf[i][0] = suf[i + 1][1];
                suf[i][1] = suf[i + 1][0] + 1;
            } else {
                suf[i][0] = suf[i + 1][1] + 1;
                suf[i][1] = suf[i + 1][0];
            }
        }
        int result = Math.min(suf[0][0], suf[0][1]);
        if ((s.length() & 1) == 0) {
            return result;
        }

        for (int i = 0; i < s.length(); i++) {
            // [0, i], [i + 1, s.length - 1] 两部分
            result = Math.min(result, Math.min(pre[i][0] + suf[i + 1][0], pre[i][1] + suf[i + 1][1]));
        }
        return result;
    }
    
}