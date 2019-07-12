package 剑指offer_后缀为书中题号;

/**
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class RebuildTree07 {
    /**
     * p62,面试题07
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = buildCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode buildCore(int[] pre, int preFirst, int preLast, int[] in, int inFirst, int inLast) {
        if (preFirst > preLast || inFirst> inLast) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preFirst]);
        int positionIN = 0;
        for (int i = inFirst; i <= inLast; i++) {
            if (in[i] == pre[preFirst]) {
                positionIN = i;
                break;
            }
        }
        // 左子树元素个数
        int left = positionIN - inFirst;
        // 右子树元素个数
        int right = inLast - positionIN;

        root.left = buildCore(pre, preFirst + 1, preFirst + left, in, inFirst, positionIN - 1);
        root.right = buildCore(pre, preFirst + left + 1, preFirst + left + 1 + right, in, positionIN + 1, inLast);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}