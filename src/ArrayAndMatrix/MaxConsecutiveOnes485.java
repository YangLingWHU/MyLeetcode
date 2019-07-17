package ArrayAndMatrix;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones
 */
public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            // 找到 =1 的数的下标
            while (i < nums.length && nums[i] != 1) {
                i++;
            }
            if (i == nums.length) {
                return max;
            }
            // 找到 =0 的数的下标
            int j = i;
            while (j < nums.length && nums[j] != 0) {
                j++;
            }
            if (j == nums.length) {
                return Math.max(max, j - i);
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
