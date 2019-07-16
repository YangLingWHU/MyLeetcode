package Tree.Recursion;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class DiameterOfBinaryTree543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        int max = leftMax + rightMax;  // 经过root的最大直径
        max = Math.max(Math.max(max, diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));
        return max;

    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        depth = depth + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
        return depth;
    }
}
