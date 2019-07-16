package Tree.Recursion;

import JVM.TestClassLoader;
import Tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class SubtreeOfAnotherTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean rt = isEqual(s, t);
        rt = rt || isSubtree(s.left, t)|| isSubtree(s.right, t);
        return rt;
    }

    /**
     * 判断两个树是否相等
     *
     * @param t1
     * @param t2
     * @return Boolean
     */
    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        boolean rt;
        if (t1 != null && t2 != null && t1.val == t2.val) {
            rt = true;
        } else {
            rt = false;
        }
        rt = rt && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
        return rt;
    }
}
