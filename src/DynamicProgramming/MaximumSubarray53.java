package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/comments/
 */
public class MaximumSubarray53 {
    /**
     * 动态规划。dp[i]表示以nums[i]为结尾的子数组的最大的和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // i和i-1相邻，所以dp[i - 1] + nums[i] = （i 的前一个 i-1 的最大和）+（自己）。
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray53 o = new MaximumSubarray53();
        o.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
