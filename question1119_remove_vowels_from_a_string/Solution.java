package question1119_remove_vowels_from_a_string;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：34.5MB，击败100.00%。
 */
public class Solution {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}