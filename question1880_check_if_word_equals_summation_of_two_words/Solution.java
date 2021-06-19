package question1880_check_if_word_equals_summation_of_two_words;

public class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return string2Integer(firstWord) + string2Integer(secondWord) == string2Integer(targetWord);
    }

    private int string2Integer(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 10 + s.charAt(i) - 'a';
        }
        return result;
    }

}
