package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 解码方法
 * 参考;https://blog.csdn.net/xygy8860/article/details/47073943
 */
public class NumberDecoding91 {
    /**
     * 采用动态规划的方式
     * dp[i]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int dp[] = new int[length];
        dp[0] = 1;
        if (length == 1) {
            return 1;
        }

        // // dp[1]的值是关键，写不好，将会出现各种错误
        if (s.charAt(0) != '0' && s.charAt(1) != '0') {
            int temp = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            if (temp <= 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        if (s.charAt(0) != '0' && s.charAt(1) == '0') {
            int temp = (s.charAt(0) - '0') * 10;
            if (temp <= 26) {
                dp[1] = 1;
            } else {
                return 0;
            }
        }


        for (int i = 2; i < length; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                return 0;
            }
            if (s.charAt(i - 1) == '0' && s.charAt(i) != 0) {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                    continue;
                } else {
                    return 0;
                }
            }
            if (s.charAt(i - 1) != '0' && s.charAt(i) != '0') {
                int temp = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                if (temp <= 26) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
                continue;
            }
            if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                int temp = (s.charAt(i - 1) - '0') * 10;
                if (temp <= 26) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
                continue;
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        NumberDecoding91 o = new NumberDecoding91();
        System.out.println(o.numDecodings("100"));
    }
}
