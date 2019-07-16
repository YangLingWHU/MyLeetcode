package Tree.Recursion;

import Tree.TreeNode;

/**
 * 参考 https://blog.csdn.net/yisizhu/article/details/52813108
 * <p>
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 并不是判断当前节点是不是叶子，而是判断当前节点的左孩子是不是叶子
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        } else {
            // 当前节点的左孩子不是叶子
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
