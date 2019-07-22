package HashTable;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * 
 * @author yangling
 *
 */
public class LongestHarmoniousSubsequence594 {
	public int findLHS(int[] nums) {
		// 和谐序列中最大数和最小数之差必须为 1，应该注意的是序列的元素不一定是数组的连续元素。
		HashMap<Integer, Integer> numAndCount = new HashMap<>(); // 存放每一个元素及其出现次数
		int longestLen = 0;
		for (int i = 0; i < nums.length; i++) {
			numAndCount.put(nums[i], numAndCount.getOrDefault(nums[i], 0) + 1);
		}
		for (Entry<Integer, Integer> entry : numAndCount.entrySet()) {
			//longestLen = Math.max(longestLen, entry.getValue()); 如果要求差值不大于1，则本行生效
			if (numAndCount.containsKey(entry.getKey()+1)) {
				longestLen = Math.max(longestLen, entry.getValue() + numAndCount.get(entry.getKey()+1));
			}
		}
		return longestLen;
	}
}
