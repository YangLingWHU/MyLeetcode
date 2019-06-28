package greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionbyHeight406 {
    // (h, k),其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数
    public int[][] reconstructQueue(int[][] people) {

        // 按照 h 的倒序，k的升序来排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }

            }
        });

        // rtList 存放要返回的数组
        // 每次遍历时，people[index]的身高小于rtList中的所有元素。
        /**
         * 假设候选队列为 A，已经站好队的队列为 B.
         * 从 A 里挑身高最高的人 x 出来，插入到 B.
         * 因为 B 中每个人的身高都比 x 要高
         * 因此 x 插入的位置，就是看 x 前面应该有多少人就行了。
         * 比如 x 前面有 5 个人，那 x 就插入到队列 B 的第 5 个位置。
         */
        List<int[]> rtList = new ArrayList<>();
        int index = 0;
        for (index = 0; index < people.length; index++){
            rtList.add(people[index][1], people[index]);
        }
        return rtList.toArray(new int[rtList.size()][]);
    }
}
