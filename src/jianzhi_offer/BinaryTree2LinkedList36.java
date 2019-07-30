package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 * 将二叉搜索树转换为有序的双向链表
 */
public class BinaryTree2LinkedList36 {
    /**
     * 将二叉搜索树转换为有序的双向链表
     * p191，面试题36
     * 中序遍历
     */
    private TreeNode preNode = null;
    private TreeNode rtHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left = preNode;
        if (preNode != null) {
            preNode.right = pRootOfTree;
        } else {
            rtHead = pRootOfTree;
        }
        preNode = pRootOfTree;
        Convert(pRootOfTree.right);

        return rtHead;
    }
}

