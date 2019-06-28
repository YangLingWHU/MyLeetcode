package BucketSort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 输入:"tree"
 * 输出:"eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        Map<Character, Integer> charAndCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charAndCount.put(s.charAt(i), (charAndCount.getOrDefault(s.charAt(i), 0)) + 1);
        }

        ArrayList<Character> list[] = new ArrayList[s.length() + 1];
        for (Map.Entry entry : charAndCount.entrySet()) {
            if (list[(int) entry.getValue()] == null) {
                list[(int) entry.getValue()] = new ArrayList<>();
            }
            list[(int) entry.getValue()].add((Character) entry.getKey());
        }
        StringBuilder rt = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (list[i] != null) {
                for (Character c : list[i]) {
                    for (int cCount = charAndCount.get(c); cCount > 0; cCount--) {
                        rt.append(c);
                    }
                }
            }
        }
        return rt.toString();
    }
}
