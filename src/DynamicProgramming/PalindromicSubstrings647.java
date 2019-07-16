package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author yangling
 * 参考 https://blog.csdn.net/zjwreal/article/details/91492795
 */
public class PalindromicSubstrings647 {
    public int countSubstrings(String s) {
        int strLen = s.length();
        int rt = 0;
        // 动态规划的思路
        // dp[i][j]表示s[i]到s[j]是否为回文串
        boolean dp[][] = new boolean[strLen][strLen];

        // 首先将长度为1和2的子串对应的dp[][]赋予初始值
        for (int i = 0; i < strLen; i++) {
            for (int j = i; j < i + 2 && j < strLen; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    rt++;
                    continue;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    rt++;
                }
            }
        }

        // 接下来利用推导公式来计算长度大于2的子串
        int currentSubLen = 2;
        while (currentSubLen < strLen) {
            for (int i = 0; i + currentSubLen < strLen; i++) {
                dp[i][i + currentSubLen] = (s.charAt(i) == s.charAt(i + currentSubLen)) && dp[i + 1][i + currentSubLen - 1];
                if (dp[i][i + currentSubLen]) {
                    rt++;
                }
            }
            currentSubLen++;
        }
        return rt;
    }

    public static void main(String[] args) {
        PalindromicSubstrings647 o = new PalindromicSubstrings647();
        System.out.println(o.countSubstrings("aaaaa"));
    }
}
