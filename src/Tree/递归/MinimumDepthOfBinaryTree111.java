package Tree.递归;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 */
public class MinimumDepthOfBinaryTree111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return 1 + left + right;
        }
        return 1 + Math.min(left, right);
    }
}
