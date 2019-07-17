package ArrayAndMatrix;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 剑指offer里面的例题
        int i = matrix.length;  // 总行数
        int j = matrix[0].length;  // 总列数

        // 首次遍历的坐标：右上角
        int currentI = 0;   // 行号
        int currentJ = j - 1;  // 列号
        while(currentI < i && currentJ >= 0) {
            if (matrix[currentI][currentJ] == target) {
                return true;
            }
            if (matrix[currentI][currentJ] > target) {
                currentJ--;
                continue;
            }
            if (matrix[currentI][currentJ] < target) {
                currentI++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII240 o = new Search2DMatrixII240();
        int [][]a = {{-5}};
        o.searchMatrix(a, -10);
    }
}
