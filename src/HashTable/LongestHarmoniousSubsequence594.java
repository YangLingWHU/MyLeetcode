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
		// ��г���������������С��֮�����Ϊ 1��Ӧ��ע��������е�Ԫ�ز�һ�������������Ԫ�ء�
		HashMap<Integer, Integer> numAndCount = new HashMap<>(); // ���ÿһ��Ԫ�ؼ�����ִ���
		int longestLen = 0;
		for (int i = 0; i < nums.length; i++) {
			numAndCount.put(nums[i], numAndCount.getOrDefault(nums[i], 0) + 1);
		}
		for (Entry<Integer, Integer> entry : numAndCount.entrySet()) {
			//longestLen = Math.max(longestLen, entry.getValue()); ���Ҫ���ֵ������1��������Ч
			if (numAndCount.containsKey(entry.getKey()+1)) {
				longestLen = Math.max(longestLen, entry.getValue() + numAndCount.get(entry.getKey()+1));
			}
		}
		return longestLen;
	}
}
