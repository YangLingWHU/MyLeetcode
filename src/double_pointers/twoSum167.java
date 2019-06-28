package double_pointers;

import java.util.HashMap;
import java.util.Map;

public class twoSum167 {

    // 本题目除了本方法，还可以使用双指针，分别指向首位，类似二分查找的思路
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            myMap.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int neededNum = target - numbers[i];
            if (myMap.containsKey(neededNum)) {
                return new int[]{i + 1, myMap.get(neededNum) + 1};
            }
        }
        return null;
    }
}
