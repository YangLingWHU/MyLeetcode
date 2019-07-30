package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 */
public class VerifySquenceOfBST33 {
    // 判断数组是不是某个二叉树的后序遍历结果
    // p179 面试题33
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifyCore(sequence, 0, sequence.length - 1);
    }

    public boolean verifyCore(int[] sequence, int start, int last) {
        // 如果一棵树只有一个或者两个元素，那么一定满足二叉搜索树
        if (last - start <= 1) {
            return true;
        }
        int root = sequence[last];
        // 数组中首个大于根节点的元素的索引
        int index = 0;
        for (int i = start; i <= last; i++) {
            if (sequence[i] >= root) {
                index = i;
                break;
            }
        }
        // 此时查看index到last之间有没有小于root的元素
        for (int i = index; i < last; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        // 依次判断左子树和右子树
        return verifyCore(sequence, start, index - 1) && verifyCore(sequence, index, last - 1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST33 o = new VerifySquenceOfBST33();
        System.out.println(o.VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
    }
}
