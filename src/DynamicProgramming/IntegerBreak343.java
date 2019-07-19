package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/integer-break
 */
public class IntegerBreak343 {
    /**
     * 也是剑指offer的14题，P96
     */
    // 动态规划，从上往下分析问题，从下往上求解问题
    // 本题有点特殊
    public int integerBreak(int n) {
        // dp[i]存放了i的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {  // dp中的第几个元素
            for (int j = 1; j < i; j++) {// dp[i]上的第j个位置切刀，此时必须小于i
                // 之所以单独考虑j * (i - j) 这种情况：
                // 是因为dp[j]不会考虑 0 + j，dp[j]不能返回自身的值，那么dp[i]也就无法考虑j * (i - j)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), Math.max(dp[j] * dp[i - j], Math.max(dp[j] * (i - j), j* dp[i - j]))));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak343 o = new IntegerBreak343();
        System.out.println(o.integerBreak(8));
    }
}
