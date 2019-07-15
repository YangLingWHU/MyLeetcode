package 剑指offer_后缀为书中题号;

/**
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class RectangleCoverP79 {
    // 矩形覆盖，p79相关题目
    // target就是大矩形的长度
    public int RectCover(int target) {
        if (target < 3) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 覆盖大矩形最左边的时候，第一个小矩形有两种方式
        // 1 竖着放，则还剩下了 2* （target-1)个空间
        // 2 横着放，则还剩下了 2* （target-2)个空间
        for (int i = 3; i < target + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
