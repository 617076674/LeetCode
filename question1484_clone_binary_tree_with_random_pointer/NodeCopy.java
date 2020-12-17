package question1484_clone_binary_tree_with_random_pointer;

public class NodeCopy {
  int val;
  NodeCopy left;
  NodeCopy right;
  NodeCopy random;

  NodeCopy() {
  }

  NodeCopy(int val) {
    this.val = val;
  }

  NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.random = random;
  }
}