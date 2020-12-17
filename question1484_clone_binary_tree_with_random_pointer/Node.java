package question1484_clone_binary_tree_with_random_pointer;

public class Node {
  int val;
  Node left;
  Node right;
  Node random;

  Node() {
  }

  Node(int val) {
    this.val = val;
  }

  Node(int val, Node left, Node right, Node random) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.random = random;
  }
}