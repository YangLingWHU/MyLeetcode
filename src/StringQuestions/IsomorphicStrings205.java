package StringQuestions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * 
 * @author yangling
 *
 */
public class IsomorphicStrings205 {
	// 同构字符串
	public boolean isIsomorphic(String s, String t) {
		// 存放字母的映射关系
		HashMap<Character, Character> f = new HashMap<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (f.containsKey(s.charAt(i)) && f.get(s.charAt(i)) != t.charAt(i)) {
				return false;
			}
			// 判断t的字母是否已经被用在某个映射之中
			if (!f.containsKey(s.charAt(i)) && f.containsValue(t.charAt(i))) {
				return false;
			}
			f.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}
}
