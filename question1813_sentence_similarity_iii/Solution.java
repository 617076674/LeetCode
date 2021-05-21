package question1813_sentence_similarity_iii;

public class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int left1 = 0, left2 = 0;
        while (left1 < words1.length && left2 < words2.length && words1[left1].equals(words2[left2])) {
            left1++;
            left2++;
        }
        if (left1 == words1.length) {
            return true;
        }
        int right1 = words1.length - 1, right2 = words2.length - 1;
        while (right1 >= left1 && right2 >= left2 && words1[right1].equals(words2[right2])) {
            right1--;
            right2--;
        }
        return left1 == right1 + 1;
    }

}