package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths62 {
    // 类似于64题，矩阵的最小路径和
    public int uniquePaths(int m, int n) {
        // 此时 m 是 列数， n 是行数
        int dp[][] = new int[n][m];
        // 因为只能向下和向右，所以左边一排和上边一排的dp可以简单的计算
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            // i行
            for (int j = 1; j < m; j++) {
                // j列
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
