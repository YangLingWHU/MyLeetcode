package greedy;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MinimumNumberofArrowstoBurstBalloons452 {

    // 是否类似于查找不重叠区间的个数？
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = points[0][1];
        int index = 1;
        int rt = 1;
        while (index < points.length) {
            if (end >= points[index][0]) {
                index++;
                continue;
            }
            end = points[index][1];
            rt++;
        }
        return rt;
    }

    public static void main(String[] args) {
        int array[][] = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int rt = new MinimumNumberofArrowstoBurstBalloons452().findMinArrowShots(array);
        System.out.println(rt);
    }
}
