package jianzhi_offer;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0
 */
public class PrintTree32_3 {
    // p174 面试题32的第三问
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> eachLevel;
        boolean reverse = false;
        if (pRoot == null) {
            return ret;
        }
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层次的结点个数
            eachLevel = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode temp = queue.poll();
                eachLevel.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            if (reverse) {
                Collections.reverse(eachLevel);
            }
            ret.add(eachLevel);
            reverse = !reverse;
        }
        return ret;
    }
}
