package StringQuestions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * 
 * @author yangling
 *
 */
public class IsomorphicStrings205 {
	// ͬ���ַ���
	public boolean isIsomorphic(String s, String t) {
		// �����ĸ��ӳ���ϵ
		HashMap<Character, Character> f = new HashMap<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (f.containsKey(s.charAt(i)) && f.get(s.charAt(i)) != t.charAt(i)) {
				return false;
			}
			// �ж�t����ĸ�Ƿ��Ѿ�������ĳ��ӳ��֮��
			if (!f.containsKey(s.charAt(i)) && f.containsValue(t.charAt(i))) {
				return false;
			}
			f.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}
}
