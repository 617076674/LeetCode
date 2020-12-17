package question1430_check_if_a_string_is_a_valid_sequence_from_root_to_leaves_path_in_a_binary_tree;

public class Solution {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    private boolean isValidSequence(TreeNode root, int[] arr, int index) {
        if (null == root || root.val != arr[index]) {
            return false;
        }
        if (index == arr.length - 1) {
            return root.left == null && root.right == null;
        }
        return isValidSequence(root.left, arr, index + 1) || isValidSequence(root.right, arr, index + 1);
    }

}