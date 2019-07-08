package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        // 在最后创建一个虚拟台阶，花费为0
        int[] newCost = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            newCost[i] = cost[i];
        }
        newCost[cost.length] = 0;

        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < newCost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + newCost[i];
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs746 o = new MinCostClimbingStairs746();
        System.out.println(o.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
