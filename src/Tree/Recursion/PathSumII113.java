package Tree.Recursion;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSumII113 {
    List<List<Integer>> rt = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return rt;
        }
        DFS(root, sum);
        return rt;
    }

    private void DFS(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            current.add(root.val);
            // 注意这里必须是新构造一个List，否则之后current的修改会影响到rt里面的元素
            rt.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
        current.add(root.val);
        DFS(root.left, sum - root.val);
        DFS(root.right, sum - root.val);
        current.remove(current.size() - 1);
    }
}
