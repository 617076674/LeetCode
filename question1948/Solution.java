package question1948;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class TrieNode {
    String serial;
    Map<String, TrieNode> children = new HashMap<>();
  }

  private Map<String, Integer> serial2Count = new HashMap<>();

  private List<List<String>> result = new ArrayList<>();

  public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
    TrieNode root = new TrieNode();
    for (List<String> path : paths) {
      TrieNode cur = root;
      for (String node : path) {
        TrieNode next = cur.children.get(node);
        if (null == next) {
          next = new TrieNode();
          cur.children.put(node, next);
        }
        cur = next;
      }
    }
    serialAllTrieNode(root);
    dfs(root, new ArrayList<>());
    return result;
  }

  private void dfs(TrieNode trieNode, List<String> curPath) {
    Integer cnt = serial2Count.get(trieNode.serial);
    if (cnt != null && cnt > 1) {
      return;
    }
    if (!curPath.isEmpty()) {
      result.add(new ArrayList<>(curPath));
    }
    for (Map.Entry<String, TrieNode> entry : trieNode.children.entrySet()) {
      curPath.add(entry.getKey());
      dfs(entry.getValue(), curPath);
      curPath.remove(curPath.size() - 1);
    }
  }

  private void serialAllTrieNode(TrieNode trieNode) {
    if (trieNode.children.isEmpty()) {
      return;
    }
    List<String> serialOfChildren = new ArrayList<>();
    for (Map.Entry<String, TrieNode> entry : trieNode.children.entrySet()) {
      serialAllTrieNode(entry.getValue());
      serialOfChildren.add(entry.getKey() + "(" + entry.getValue().serial + ")");
    }
    Collections.sort(serialOfChildren);
    StringBuilder sb = new StringBuilder();
    for (String temp : serialOfChildren) {
      sb.append(temp);
    }
    trieNode.serial = sb.toString();
    serial2Count.put(trieNode.serial, serial2Count.getOrDefault(trieNode.serial, 0) + 1);
  }

}