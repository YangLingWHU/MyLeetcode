package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
 * 连续子数组的最大和
 */
public class MaxSumOfSubArray42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        // dp[i] 表示 以array[i]为结尾的连续子数组的最大和。跟正负数没关系
        int dp[] = new int[length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
