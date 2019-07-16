package Tree.LevelTraversal;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int rt = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();  // 当前层元素的个数
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            rt = temp.val;

            // 把当前层的元素都去掉
            while (count > 1) {
                TreeNode temp2 = queue.poll();
                if (temp2.left != null) {
                    queue.offer(temp2.left);
                }
                if (temp2.right != null) {
                    queue.offer(temp2.right);
                }
                count--;
            }
        }
        return rt;
    }
}
