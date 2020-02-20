package question0423_reconstruct_original_digits_from_english;

/**
 * 时间复杂度是O(n)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败82.35%。消耗内存：41.4MB，击败6.28%。
 */
public class Solution {
    public String originalDigits(String s) {
        int[] countLetter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countLetter[s.charAt(i) - 'a']++;
        }
        int[] countNum = new int[10];
        // "zero"       z
        countNum[0] = countLetter['z' - 'a'];
        // "one"        o - z - w - u
        countNum[1] = countLetter['o' - 'a'] - countLetter['z' - 'a'] - countLetter['w' - 'a'] - countLetter['u' - 'a'];
        // "two"        w
        countNum[2] = countLetter['w' - 'a'];
        // "three"      r - z - u
        countNum[3] = countLetter['r' - 'a'] - countLetter['z' - 'a'] - countLetter['u' - 'a'];
        // "four"       u
        countNum[4] = countLetter['u' - 'a'];
        // "five"       f - u
        countNum[5] = countLetter['f' - 'a'] - countLetter['u' - 'a'];
        // "six"        x
        countNum[6] = countLetter['x' - 'a'];
        // "seven"      s - x
        countNum[7] = countLetter['s' - 'a'] - countLetter['x' - 'a'];
        // "eight"      g
        countNum[8] = countLetter['g' - 'a'];
        // "nine"       i - g - x - f + u
        countNum[9] = countLetter['i' - 'a'] + countLetter['u' - 'a'] - countLetter['g' - 'a'] - countLetter['x' - 'a'] - countLetter['f' - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < countNum[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}