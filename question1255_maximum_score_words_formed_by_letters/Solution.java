package question1255_maximum_score_words_formed_by_letters;

public class Solution {

  private int[] map = new int[26];

  private int[] scoreMap;

  private int[][] wordsMap;

  private Integer[][] memo;

  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    for (char letter : letters) {
      map[letter - 'a']++;
    }
    scoreMap = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      scoreMap[i] = calculateScore(words[i], score);
    }
    wordsMap = new int[words.length][26];
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        wordsMap[i][words[i].charAt(j) - 'a']++;
      }
    }
    memo = new Integer[words.length][1 << 15];
    return maxScoreWordsHelper(words.length - 1, 0);
  }

  public static void main(String[] args) {
    String[] words = {"dog","cat","dad","good"};
    char[] letters = {'a','a','c','d','d','d','g','o','o'};
    int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
    System.out.println(new Solution().maxScoreWords(words, letters, score));
  }

  private static int calculateScore(String word, int[] score) {
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      result += score[word.charAt(i) - 'a'];
    }
    return result;
  }

  /**
   * 考虑 words 数组中 [0, index] 范围内的元素，其能得到的最大分数。
   */
  private int maxScoreWordsHelper(int index, int status) {
    if (index == -1) {
      return 0;
    }
    if (memo[index][status] != null) {
      return memo[index][status];
    }
    // 不考虑第 index 个单词
    int result = maxScoreWordsHelper(index - 1, status);
    if (check(index)) {
      // 考虑第 index 个单词
      for (int i = 0; i < 26; i++) {
        map[i] -= wordsMap[index][i];
      }
      result = Math.max(result, scoreMap[index] + maxScoreWordsHelper(index - 1, status ^ (1 << index)));
      for (int i = 0; i < 26; i++) {
        map[i] += wordsMap[index][i];
      }
    }
    memo[index][status] = result;
    return result;
  }

  private boolean check(int index) {
    int[] wordMap = wordsMap[index];
    for (int i = 0; i < wordMap.length; i++) {
      if (wordMap[i] > map[i]) {
        return false;
      }
    }
    return true;
  }

}