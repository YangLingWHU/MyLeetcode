package Tree.递归;

import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class PathSumIII437 {
    int rt = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        DFS(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return rt;
    }

    public void DFS(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            rt++;
        }
        DFS(root.left, sum - root.val);
        DFS(root.right, sum - root.val);
    }
}
