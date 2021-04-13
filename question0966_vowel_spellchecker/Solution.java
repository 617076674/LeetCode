package question0966_vowel_spellchecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Set<String> wordsPerfect = new HashSet<>();

  private Map<String, String> wordsCap = new HashMap<>();

  private Map<String, String> wordsVow = new HashMap<>();

  public String[] spellchecker(String[] wordlist, String[] queries) {
    for (String word : wordlist) {
      wordsPerfect.add(word);
      String wordlow = word.toLowerCase();
      wordsCap.putIfAbsent(wordlow, word);
      String wordlowDV = devowel(wordlow);
      wordsVow.putIfAbsent(wordlowDV, word);
    }
    String[] result = new String[queries.length];
    int i = 0;
    for (String query : queries) {
      result[i++] = solve(query);
    }
    return result;
  }

  public String solve(String query) {
    if (wordsPerfect.contains(query)) {
      return query;
    }
    String queryL = query.toLowerCase(), result = wordsCap.get(queryL);
    if (null != result) {
      return result;
    }
    String queryLV = devowel(queryL);
    result = wordsVow.get(queryLV);
    return null == result ? "" : result;
  }

  public String devowel(String word) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      sb.append(isVowel(c) ? '*' : c);
    }
    return sb.toString();
  }

  public boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
  }

}