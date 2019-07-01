package DFS;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 非递归dfs
 */
public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Stack<Pair> stack = new Stack<>();
        int count = 0;
        int m = grid.length;   // 行数
        int n = grid[0].length;  // 列数
        boolean[][] marked = new boolean[m][n];

        for (int indexI = 0; indexI < m; indexI++) {
            for (int indexJ = 0; indexJ < n; indexJ++) {
                if (grid[indexI][indexJ] == '1' && marked[indexI][indexJ] == false) {
                    stack.push(new Pair(indexI, indexJ));
                    marked[indexI][indexJ] = true;
                    count++;
                    while (stack.size() != 0) {
                        Pair current = stack.pop();
                        int i = current.key;  // 当前点的行号
                        int j = current.value;// 当前点的列号
                        if (i + 1 < m && grid[i + 1][j] == '1' && marked[i + 1][j] == false) {  // 下
                            stack.push(new Pair(i + 1, j));
                            marked[i + 1][j] = true;
                        }
                        if (j + 1 < n && grid[i][j + 1] == '1' && marked[i][j + 1] == false) {   // 右
                            stack.push(new Pair(i, j + 1));
                            marked[i][j + 1] = true;
                        }
                        if (i - 1 >= 0 && grid[i - 1][j] == '1' && marked[i - 1][j] == false) {   // 上
                            stack.push(new Pair(i - 1, j));
                            marked[i - 1][j] = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == '1' && marked[i][j - 1] == false) {    // 左
                            stack.push(new Pair(i, j - 1));
                            marked[i][j - 1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        NumberOfIslands200 numberOfIslands200 = new NumberOfIslands200();
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        numberOfIslands200.numIslands(grid);
    }
}
