package question0331_verify_preorder_serialization_of_a_binary_tree;

/**
 * 二叉树有一个性质就是整棵树叶子节点的个数比内部节点的个数大1，当然在遍历的过程中，叶子节点的个数一定是小于等于内部节点的个数的，
 * 如果不满足这个条件，证明有根节点为空，直接返回false。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：6ms，击败89.86%。消耗内存：37.3MB，击败22.55%。
 */
public class Solution2 {

  public boolean isValidSerialization(String preorder) {
    if (null == preorder || preorder.length() == 0) {
      return true;
    }
    int leaves = 0, nonLeaves = 0;
    String[] arr = preorder.split(",");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("#")) {
        leaves++;
      } else {
        nonLeaves++;
      }
      if (i != arr.length - 1 && leaves > nonLeaves) {
        return false;
      }
    }
    return leaves == nonLeaves + 1;
  }

}