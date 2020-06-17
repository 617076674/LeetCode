package question1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}