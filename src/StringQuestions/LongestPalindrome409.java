package StringQuestions;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 
 * @author yangling
 *
 */
public class LongestPalindrome409 {
	public int longestPalindrome(String s) {
		HashMap<Character, Integer> charAndCount = new HashMap<>();
		int longest = 0;
		boolean hasOdd = false;
		for (char c : s.toCharArray()) {
			charAndCount.put(c, charAndCount.getOrDefault(c, 0) + 1);
		}
		for (Entry<Character, Integer> entry : charAndCount.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				hasOdd = true;
			}
			longest += entry.getValue() / 2 * 2;

		}
		if (hasOdd) {
			longest++;
		}
		return longest;
	}
}
