package Tree.层次遍历;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int count = queue.size();
            int tempCount = count;
            long sum = 0;
            while (tempCount > 0) {

                tempCount--;
                TreeNode temp = queue.poll();
                sum += temp.val;

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            rt.add((double)sum / count);
        }
        return rt;
    }
}
