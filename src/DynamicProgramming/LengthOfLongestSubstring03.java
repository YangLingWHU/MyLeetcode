package DynamicProgramming;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长字串
 */
public class LengthOfLongestSubstring03 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        // dp[i]表示第i个字符为结尾的、满足不重复条件的字符串的长度
        // 结合哈希表
        int dp[] = new int[length];
        dp[0] = 1;
        int max = 1;
        // 存放已经出现过的字符和位置，如果有重复出现也没关系。因为我只关心离当前元素最近的那个重复元素
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                if (i - map.get(s.charAt(i)) > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else if (i - map.get(s.charAt(i)) == dp[i - 1]) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = i - map.get(s.charAt(i));
                }
            }
            map.put(s.charAt(i), i);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring03 o = new LengthOfLongestSubstring03();
        o.lengthOfLongestSubstring("pwwkew");
    }
}