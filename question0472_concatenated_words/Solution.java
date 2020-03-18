package question0472_concatenated_words;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：57ms，击败77.89%。消耗内存：56.4MB，击败17.39%。
 */
public class Solution {
    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) {
            if (word.length() > 0) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    int num = word.charAt(i) - 'a';
                    TrieNode trieNode = cur.next[num];
                    if (null == trieNode) {
                        cur.next[num] = new TrieNode();
                    }
                    cur = cur.next[num];
                }
                if (!cur.isWord) {
                    cur.isWord = true;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (dfs(word, root, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean dfs(String word, TrieNode trieNode, int count, int index) {
        for (int i = index; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if (trieNode.next[num] == null) {
                return false;
            }
            trieNode = trieNode.next[num];
            if (trieNode.isWord && dfs(word, root, count + 1, i + 1)) {
                return true;
            }
        }
        return count > 0 && trieNode.isWord;
    }

    private class TrieNode {
        private boolean isWord; //判断是否是一个单词

        private TrieNode[] next;  //指向next节点

        TrieNode() {
            this.next = new TrieNode[26];
        }
    }
}