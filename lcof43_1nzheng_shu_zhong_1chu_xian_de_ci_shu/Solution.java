package lcof43_1nzheng_shu_zhong_1chu_xian_de_ci_shu;

public class Solution {

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '1') {
                    result += 1;
                    if (s.length() > 1) {
                        result += Integer.parseInt(s.substring(1));
                    }
                } else if (c != '0') {
                    result += Math.pow(10, s.length() - 1);
                }
            } else if (i == s.length() - 1) {
                result += Integer.parseInt(s.substring(0, s.length() - 1));
                if (c != '0') {
                    result++;
                }
            } else {
                result += Integer.parseInt(s.substring(0, i)) * Math.pow(10, s.length() - i - 1);
                if (c == '1') {
                    result += Integer.parseInt(s.substring(i + 1)) + 1;
                } else if (c != '0'){
                    result += Math.pow(10, s.length() - i - 1);
                }
            }
        }
        return result;
    }

}