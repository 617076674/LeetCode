package question1268_search_suggestions_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static class TrieNode {
        private String word;
        private TrieNode[] next = new TrieNode[26];
    }

    private static class Trie {
        private TrieNode root = new TrieNode();

        private void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.word = s;
        }
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(new Solution().suggestedProducts(products, searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode cur = trie.root;
        for (int i = 0; i < searchWord.length(); i++) {
            int index = searchWord.charAt(i) - 'a';
            if (null == cur) {
                break;
            }
            cur = cur.next[index];
            result.add(dfs(cur));
        }
        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }
        return result;
    }

    private Map<TrieNode, List<String>> memo = new HashMap<>();

    private List<String> dfs(TrieNode temp) {
        if (temp == null) {
            return new ArrayList<>();
        }
        List<String> result = memo.get(temp);
        if (null != result) {
            return result;
        }
        result = new ArrayList<>();
        if (temp.word != null) {
            result.add(temp.word);
        }
        for (int i = 0; i < 26; i++) {
            result.addAll(dfs(temp.next[i]));
            if (result.size() >= 3) {
                result = result.subList(0, 3);
                memo.put(temp, result);
                return result;
            }
        }
        memo.put(temp, result);
        return result;
    }

}