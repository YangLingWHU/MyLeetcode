package Tree.Recursion;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        height = height + Math.max(maxDepth(root.left), maxDepth(root.right));
        return height;
    }
}
