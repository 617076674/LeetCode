package question0208_implement_trie_prefix_tree;

/**
 * 执行用时：140ms，击败92.77%。消耗内存：52.5MB，击败91.61%。
 */
public class Trie {

  private class Node {

    private boolean isWord; //判断是否是一个单词

    private Node[] next = new Node[26];  //指向next节点

    Node(boolean isWord) {
      this.isWord = isWord;
    }

    Node() {
      this(false);
    }

  }

  private Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      Node node = cur.next[index];
      if (null == node) {
        cur.next[index] = new Node();
      }
      cur = cur.next[index];
    }
    if (!cur.isWord) {
      cur.isWord = true;
    }
  }

  public boolean search(String word) {
    Node node = find(word);
    if (null == node) {
      return false;
    }
    return node.isWord;
  }

  public boolean startsWith(String prefix) {
    return find(prefix) != null;
  }

  private Node find(String string) {
    Node cur = root;
    for (int i = 0; i < string.length(); i++) {
      int index = string.charAt(i) - 'a';
      Node node = cur.next[index];
      if (null == node) {
        return null;
      }
      cur = cur.next[index];
    }
    return cur;
  }

}