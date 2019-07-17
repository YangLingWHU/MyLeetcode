package ArrayAndMatrix;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        // 双指针思想, 原来的非0元素的相对位置不变，但是各个0之间的相对位置会变（这不重要）
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (i < len && nums[i] != 0) {
                i++;
            }
            if (i >= len) {
                return;
            }
            int j = i; // 从当前0的位置开始找第一个不为0的元素
            while (j < len && nums[j] == 0) {
                j++;
            }
            if (j >= len) {
                return;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 o = new MoveZeroes283();
        int[] a = new int[]{0,1,0,3,12};
        o.moveZeroes(a);
    }
}
