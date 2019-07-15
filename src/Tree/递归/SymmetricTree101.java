package Tree.递归;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * <p>
 * https://cyc2018.github.io/CS-Notes/#/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%A0%91?id=_8-%e5%ad%90%e6%a0%91
 * 判断镜像对称
 */
public class SymmetricTree101 {
    // 层次遍历失效
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
    }
}
