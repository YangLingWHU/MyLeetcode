package HashTable;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 
 * @author yangling
 *
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
			if (hashSet.contains(nums[i])) {
				return true;
			}
			hashSet.add(nums[i]);
		}
        return false;
    }
}
