package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288
 * 按照层次来打印二叉树
 */
public class PrintTree32_2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> eachLevel;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;  // 每层的计数
        if (pRoot == null) {
            return ret;
        }
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            count = queue.size();  // 当前层次的数量
            eachLevel = new ArrayList<>();
            while (count > 0) {
                TreeNode temp = queue.poll();
                count--;
                eachLevel.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            ret.add(eachLevel);
        }

        return ret;
    }
}
