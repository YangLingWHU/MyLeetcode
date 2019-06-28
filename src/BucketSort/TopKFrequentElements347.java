package BucketSort;

import java.util.*;

public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // key 是 每个数字， value 是 数字出现的次数
        Map<Integer, Integer> numAndCount = new HashMap<>();
        for (int num : nums) {
            if (numAndCount.containsKey(num)) {
                numAndCount.put(num, numAndCount.get(num) + 1);
            } else {
                numAndCount.put(num, 1);
            }
        }

        // 简单的数组不能输出具体的数字，只能输出次数.必须用List组成的数组
        //int len = numAndCount.size();
        //int array[] = new int[len];
        //for (Map.Entry<Integer, Integer> entry : numAndCount.entrySet()) {
        //array[entry.getKey()] = entry.getValue();
        //}

        // 一个list组成的数组，数组中的每个list存放了同频率的数字，数组的下标表示了 次数
        int lenNums = nums.length;
        ArrayList<Integer> list[] = new ArrayList[lenNums + 1];
        for (Map.Entry<Integer, Integer> entry : numAndCount.entrySet()) {
            if (list[entry.getValue()] == null) {
                list[entry.getValue()] = new ArrayList<>();
            }
            list[entry.getValue()].add(entry.getKey());
        }

        List<Integer> rtList = new ArrayList<>();
        for (int i = lenNums; i >= 0; i--) {
            if (list[i] != null) {
                // 将list[i]中的所有元素赋值到rtList中
                for (int num : list[i]) {
                    rtList.add(num);
                }
            }
        }
        return rtList.subList(0, k);
    }

    public static void main(String[] args) {
        int nums[] = {-1, -1};
        TopKFrequentElements347 o = new TopKFrequentElements347();
        System.out.println(o.topKFrequent(nums, 1));
    }
}
