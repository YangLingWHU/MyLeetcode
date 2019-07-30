package jianzhi_offer;

/**
 * https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 * 礼物的最大价值，类似leetcode62
 */
public class MostValueOfGift47 {
    public int getMost(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int dp[][] = new int[board.length][board[0].length];
        // 初始化dp的最上面的边和最左面的边的值
        dp[0][0] = board[0][0];
        for (int i = 1; i < board[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < board.length; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + board[i][j];
            }
        }
        return dp[board.length - 1][board[0].length - 1];
    }
}
