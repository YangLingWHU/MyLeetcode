package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 * 将给定的树改为镜像对称,leetcode中相似的101题是判断两棵树是否为镜像对称
 */
public class MirrorTree27 {
    // 面试题27，p157
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
