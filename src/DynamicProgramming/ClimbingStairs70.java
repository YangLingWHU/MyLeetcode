package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 第 i 个楼梯可以根据
 * i-1（再走一步，有一种）
 * 和
 * i-2 （① 走一步，再走一步，与上一种情况相同，舍弃   ②直接走两步）
 * 个台阶来计算
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }
        int[] dp = new int[n + 1];  // dp[i]存放的是到达第i个台阶有几种走法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
