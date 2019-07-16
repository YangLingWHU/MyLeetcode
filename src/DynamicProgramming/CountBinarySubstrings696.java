package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings696 {
    public int countBinarySubstrings1(String s) {
        int sLen = s.length();
        int rt = 0;
        // 这种动态规划的思想,会超时
        // dp[i][i]
        boolean dp[][] = new boolean[sLen][sLen];
        // 初始化dp,子串长度为1的话dp为默认的false，为2的话则需要判断
        for (int i = 0; i < sLen - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                rt++;
            }
        }
        int currentSubLen = 3;
        while (currentSubLen < sLen) {
            int diff = sLen - currentSubLen;
            for (int i = 0; i < diff; i++) {
                dp[i][i + currentSubLen] =
                        dp[i + 1][i + currentSubLen - 1] &&
                                (s.charAt(i) == s.charAt(i + 1)) &&
                                (s.charAt(i + currentSubLen) == s.charAt(i + currentSubLen - 1));
                rt += dp[i][i + currentSubLen] ? 1 : 0;
            }
            currentSubLen += 2;
        }
        return rt;
    }

    // https://blog.csdn.net/dreamer841119554/article/details/79927780
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings696 o = new CountBinarySubstrings696();
        System.out.println(o.countBinarySubstrings("00110"));
    }
}
