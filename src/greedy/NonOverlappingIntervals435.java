package greedy;

// https://leetcode-cn.com/problems/non-overlapping-intervals/

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 将intervals按照尾节点从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 用前一个的end和下一个的head进行比较.
        // 排序之后如何判断两个区间有重合？
        // 用前一个的end大于下一个的head则代表重合
        int rt = 1;  // rt指的时不重叠的区间数量
        int end = intervals[0][1];
        int index = 1;
        while (index < intervals.length) {
            if (end > intervals[index][0]) {
                index++;
                continue;
            }
            end = intervals[index][1];
            rt++;
        }
        return intervals.length - rt;

    }
    public static void main(String[] args) {
        int x = new NonOverlappingIntervals435().eraseOverlapIntervals(new int[][]{{1, 2},{1, 2},{1, 2}});
        System.out.println(x);
    }
}
