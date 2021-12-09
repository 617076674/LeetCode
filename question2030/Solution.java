package question2030;

public class Solution {

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int letterCnt = 0;  // 记录后面还没有扫描到的 letter 数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                letterCnt++;
            }
        }
        int toErase = s.length() - k;
        StringBuilder sb = new StringBuilder();
        int curLetterCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            while (toErase > 0 && sb.length() > 0 && s.charAt(i) < sb.charAt(sb.length() - 1)) {
                if (sb.charAt(sb.length() - 1) == letter) {
                    if (repetition > curLetterCnt - 1 + letterCnt) {
                        break;
                    }
                    curLetterCnt--;
                }
                sb.deleteCharAt(sb.length() - 1);
                toErase--;
            }
            if (s.charAt(i) == letter) {
                curLetterCnt++;
                letterCnt--;
            }
            sb.append(s.charAt(i));
        }
        while (sb.length() > k) {
            if (sb.charAt(sb.length() - 1) == letter) {
                curLetterCnt--;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        for (int i = k - 1; i >= 0; i--) {
            if (curLetterCnt < repetition && sb.charAt(i) != letter) {
                sb.setCharAt(i, letter);
                curLetterCnt++;
            }
        }
        return sb.toString();
    }

}