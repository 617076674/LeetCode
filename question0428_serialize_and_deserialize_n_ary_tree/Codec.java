package question0428_serialize_and_deserialize_n_ary_tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 和 question0297 同样的思路，只是在记录节点值的时候额外记录该节点的孩子数。
 *
 * 执行用时：13ms，击败52.73%。消耗内存：40.3MB，击败88.48%。
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node now = stack.pop();
      if (null == now) {
        sb.append("#,");
      } else {
        sb.append(now.val).append("-").append(now.children.size()).append(",");
        for (int i = now.children.size() - 1; i >= 0; i--) {
          stack.push(now.children.get(i));
        }
      }
    }
    return sb.toString().substring(0, sb.length() - 1);
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    String[] nodes = data.split(",");
    Stack<String> stack = new Stack<>();
    for (int i = nodes.length - 1; i >= 0; i--) {
      stack.push(nodes[i]);
    }
    return deserialize(stack);
  }

  private Node deserialize(Stack<String> stack) {
    String first = stack.pop();
    if (first.equals("#")) {
      return null;
    }
    String[] valAndChildrenSize = first.split("-");
    Node root = new Node(Integer.parseInt(valAndChildrenSize[0]));
    root.children = new ArrayList<>();
    for (int i = 0; i < Integer.parseInt(valAndChildrenSize[1]); i++) {
      root.children.add(deserialize(stack));
    }
    return root;
  }

}