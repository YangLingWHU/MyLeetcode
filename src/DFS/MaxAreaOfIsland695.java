package DFS;


/**
 * https://leetcode-cn.com/problems/max-area-of-island/comments/
 * 查找最大的连通面积
 */
public class MaxAreaOfIsland695 {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;
        int m = grid.length;        // 行数
        int n = grid[0].length;     // 列数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if ( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        for (int []direction : directions) {
            area += dfs(grid,i+direction[0], j+ direction[1]);
        }
        return area;
    }


}
