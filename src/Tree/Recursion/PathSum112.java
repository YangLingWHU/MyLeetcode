package Tree.Recursion;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class PathSum112 {

    // 多次练习

    boolean rt = false;
    int path = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        DFS(root, sum);
        return rt;
    }

    public void DFS(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (path == sum && root.left == null && root.right == null) {
            rt = true;
        }
        DFS(root.left, sum);
        DFS(root.right, sum);
        // 不管有没有找到正确的值，都要回溯path
        path -= root.val;
    }
}
