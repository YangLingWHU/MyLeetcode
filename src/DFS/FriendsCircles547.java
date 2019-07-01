package DFS;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class FriendsCircles547 {
    /**
     * 每个人看作一个节点，如果M[i][i]=1，则i和j之间存在边
     */
    public int findCircleNum(int[][] M) {
        int students = M.length;  // 总人数
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        boolean marked[] = new boolean[students];

        for (int student = 0; student < students; student++) {
            if (marked[student] == false) {
                count++;
                stack.push(student);
                marked[student] = true;
                while (stack.size() > 0) {
                    int current = stack.pop();
                    for (int i = 0; i < students; i++) {
                         if (M[current][i] == 1 && marked[i] == false) {
                            stack.push(i);
                            marked[i] = true;
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int grid[][] = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        FriendsCircles547 friendsCircles547 = new FriendsCircles547();
        System.out.println(friendsCircles547.findCircleNum(grid));
    }
}
