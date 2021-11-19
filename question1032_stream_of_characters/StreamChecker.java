package question1032_stream_of_characters;

public class StreamChecker {

    private static class TrieNode {

        boolean isWord;

        TrieNode[] next = new TrieNode[26];

    }

    private static class Trie {

        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean find(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.isWord) {
                    return true;
                }
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return cur.isWord;
        }

    }

    private Trie trie = new Trie();

    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return trie.find(sb.toString());
    }

}