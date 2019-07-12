package Tree.递归;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null) && (root.right == null)) {
            return true;
        }
        boolean rt;
        int diffDepth = getMaxDepth(root.left) - getMaxDepth(root.right);
        if (diffDepth > 1 || diffDepth < -1) {
            // 只要在整个遍历中，有一次是false，那么整个的最终结果就是false；
            rt = false;
        } else {
            rt = true;
        }
        rt = rt && isBalanced(root.left) && isBalanced(root.right);
        return rt;
    }

    // 取得一棵树的最大高度
    int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        height = height + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
        return height;
    }
}
