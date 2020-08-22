package question0109_convert_sorted_list_to_binary_search_tree;

public class TreeNode {
  int val;

  TreeNode left;

  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}