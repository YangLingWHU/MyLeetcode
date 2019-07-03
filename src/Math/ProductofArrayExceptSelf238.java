package Math;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 动态规划的思想，但是违反了不能除法的限制
 */
public class ProductofArrayExceptSelf238 {
    // 动态规划的思想，但是违反了不能除法的限制
    public int[] productExceptSelf(int[] nums) {
        int product[] = new int[nums.length];
        // 需要查看数组中是否有0
        int zeroCount = 0;
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zero = i;
            }
        }
        if (zeroCount == 1) {
            int cal = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i==zero) {
                    continue;
                }
                cal = cal * nums[i];
            }
            product[zero] = cal;
            return product;
        }
        if (zeroCount > 1) {
            return product;
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        // 建立dp数组
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] * nums[i];
        }

        product[0] = dp[nums.length - 1] / nums[0];
        for (int i = 1; i < nums.length; i++) {
            product[i] = dp[i - 1] * (dp[nums.length - 1] / dp[i]);
        }
        return product;
    }
}
