package DynamicProgramming;

import org.omg.PortableInterceptor.HOLDING;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber198 {
    // 耗时高的方法，不采用：穷举得到所有情况的金额，取最高
    // 采用动态规划的思想
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber198 o = new HouseRobber198();
        o.rob(new int[]{1, 2, 3, 1});
    }
}
