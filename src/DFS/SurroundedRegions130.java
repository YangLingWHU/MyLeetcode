package DFS;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions130 {
    // 查找所有由O组成的连通分量
    // 如果在某一个连通分量上有个O位于边界，那么这个连通分量不能被填充
    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;   // 总行数
        int n = board[0].length;  // 总列数
        boolean marked[][] = new boolean[m][n];
        boolean surrounded = true;
        Stack<Pair> stack = new Stack<>();
        Stack<Pair> currentStack = new Stack<>();  // 本次遍历中所有遍历得到的O点坐标

        for (int indexI = 0; indexI < m; indexI++) {
            for (int indexJ = 0; indexJ < n; indexJ++) {
                if ((board[indexI][indexJ] == 'X') || marked[indexI][indexJ]) {
                    continue;
                }
                currentStack.push(new Pair(indexI, indexJ));
                stack.push(new Pair(indexI, indexJ));

                if (indexI == 0 || indexI == m - 1 || indexJ == 0 || indexJ == n - 1) {
                    surrounded = false;
                }
                while (stack.size() != 0) {
                    Pair currentPair = stack.pop();
                    int i = currentPair.key;
                    int j = currentPair.value;
                    // 左
                    if (j - 1 >= 0 && board[i][j - 1] == 'O' && marked[i][j - 1] == false) {
                        marked[i][j - 1] = true;
                        currentStack.push(new Pair(i, j - 1));
                        stack.push(new Pair(i, j - 1));
                        if (j - 1 == 0) {
                            surrounded = false;
                        }
                    }
                    // 下
                    if (i + 1 < m && board[i + 1][j] == 'O' && marked[i + 1][j] == false) {
                        marked[i + 1][j] = true;
                        currentStack.push(new Pair(i + 1, j));
                        stack.push(new Pair(i + 1, j));
                        if (i + 1 == m - 1) {
                            surrounded = false;
                        }
                    }
                    // 右
                    if (j + 1 < n && board[i][j + 1] == 'O' && marked[i][j + 1] == false) {
                        marked[i][j + 1] = true;
                        currentStack.push(new Pair(i, j + 1));
                        stack.push(new Pair(i, j + 1));
                        if (j + 1 == n - 1) {
                            surrounded = false;
                        }
                    }
                    // 上
                    if (i - 1 >= 0 && board[i - 1][j] == 'O' && marked[i - 1][j] == false) {
                        marked[i - 1][j] = true;
                        currentStack.push(new Pair(i - 1, j));
                        stack.push(new Pair(i - 1, j));
                        if (i - 1 == 0) {
                            surrounded = false;
                        }
                    }
                }
                if (surrounded == true) {
                    // 表明本次遍历中，O的区域被包围了
                    // 将currentStack中的每个点都赋值为X
                    while (currentStack.size() > 0) {
                        Pair currentPair = currentStack.pop();
                        int i = currentPair.key;
                        int j = currentPair.value;
                        board[i][j] = 'X';
                    }
                } else {
                    currentStack.clear();
                    surrounded = true;
                }
            }
        }

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
        SurroundedRegions130 o = new SurroundedRegions130();
        char grid[][] = {
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        };
        o.solve(grid);
    }

}
