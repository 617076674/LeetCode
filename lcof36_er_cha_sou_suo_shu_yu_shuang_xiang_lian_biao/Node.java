package lcof36_er_cha_sou_suo_shu_yu_shuang_xiang_lian_biao;

public class Node {
  public int val;

  public Node left;

  public Node right;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right) {
    val = _val;
    left = _left;
    right = _right;
  }
}