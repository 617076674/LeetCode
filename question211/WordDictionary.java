package question211;

import java.util.HashMap;

class WordDictionary {
	private class Node {
		private boolean isWord;
		private HashMap<Character, Node> next;
		public Node() {
			isWord = false;
			next = new HashMap<>();
		}
	}
	private Node root;
    public WordDictionary() {
    	root = new Node();
    }
    public void addWord(String word) {
    	Node cur = root;
    	for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
    	if(!cur.isWord) {
    		cur.isWord = true;
    	}
    }
    public boolean search(String word) {
    	return match(root, word, 0);
    }
	private boolean match(Node node, String word, int i) {
		if(i == word.length()) {
			return node.isWord;		//不应该直接返回true，这是不是一个单词要看这个节点的isWord属性
		}
		char c = word.charAt(i);
		if(c != '.') {
			if(node.next.get(c) == null) {
				return false;
			}
			return match(node.next.get(c), word, i + 1);
		}else {
			for(char nextChar : node.next.keySet()) {
				if(match(node.next.get(nextChar), word, i + 1)) {
					return true;
				}
			}
			return false;
		}
	}
}