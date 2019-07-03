package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int dp1[] = new int[nums.length - 1]; // 从 0 到 倒数第二个
        int dp2[] = new int[nums.length - 1]; // 从 1 到 最后一个
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[2], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }

    public static void main(String[] args) {
        HouseRobberII213 o = new HouseRobberII213();
        o.rob(new int[]{1,2,3,1});
    }
}
