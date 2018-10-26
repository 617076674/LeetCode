package question094;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82056504
 */
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		return list;
	}
	
	private void inorderTraversal(TreeNode treeNode, List<Integer> list) {
		if(treeNode == null) {
			return;
		}
		inorderTraversal(treeNode.left, list);
		list.add(treeNode.val);
		inorderTraversal(treeNode.right, list);
	}
}
