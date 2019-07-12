package Tree.递归;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class MergeTwoBinaryTrees226 {
    // 同时先序遍历两个二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 只要有一个为null，就返回null或者不为null的那个
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode temp = new TreeNode(t1.val + t2.val);
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);
        return temp;
    }
}
