package question095;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83238993
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
        List<TreeNode> list = generateTrees(arrayList);
        return list;
    }

    private List<TreeNode> generateTrees(ArrayList<Integer> arrayList) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (arrayList.size() == 1) {
            TreeNode treeNode = new TreeNode(arrayList.get(0));
            treeNodeList.add(treeNode);
            return treeNodeList;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();
            for (int j = 0; j < arrayList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (arrayList.get(j) < arrayList.get(i)) {
                    less.add(arrayList.get(j));
                } else {
                    greater.add(arrayList.get(j));
                }
            }
            if (less.size() != 0 && greater.size() != 0) {
                List<TreeNode> leftTreeNodeList = generateTrees(less);
                List<TreeNode> rightTreeNodeList = generateTrees(greater);
                for (TreeNode leftTreeNode : leftTreeNodeList) {
                    for (TreeNode rightTreeNode : rightTreeNodeList) {
                        TreeNode tempNode = new TreeNode(arrayList.get(i));
                        tempNode.left = leftTreeNode;
                        tempNode.right = rightTreeNode;
                        treeNodeList.add(tempNode);
                    }
                }
            }else if(less.size() == 0 && greater.size() != 0){
                List<TreeNode> rightTreeNodeList = generateTrees(greater);
                for (TreeNode rightTreeNode : rightTreeNodeList) {
                    TreeNode tempNode = new TreeNode(arrayList.get(i));
                    tempNode.left = null;
                    tempNode.right = rightTreeNode;
                    treeNodeList.add(tempNode);
                }
            }else if(less.size() != 0 && greater.size() == 0){
                List<TreeNode> leftTreeNodeList = generateTrees(less);
                for (TreeNode leftTreeNode : leftTreeNodeList) {
                    TreeNode tempNode = new TreeNode(arrayList.get(i));
                    tempNode.left = leftTreeNode;
                    tempNode.right = null;
                    treeNodeList.add(tempNode);
                }
            }
        }
        return treeNodeList;
    }
}
