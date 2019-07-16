package HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int complement = 0;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement) && i != map.get(complement)) {
                a = i;
                break;
            }
        }
        return new int[]{a, map.get(complement)};
    }

    public static void main(String[] args) {
        TwoSum1 o = new TwoSum1();
        o.twoSum(new int[]{3,2,4}, 6);
    }
}
