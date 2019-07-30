package jianzhi_offer;

import java.util.ArrayList;

public class PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> rt = new ArrayList<>();
        // 先打印矩阵的最外围的圈，然后依次打印内部的圈
        int col2 = matrix[0].length - 1;
        int row2 = matrix.length - 1;
        int col1 = 0;
        int row1 = 0;
        while (col1 <= col2 && row1 <= row2) {
            for (int col = col1; col <= col2; col++) {
                rt.add(matrix[row1][col]);
            }
            for (int row = row1 + 1; row <= row2; row++) {
                rt.add(matrix[row][col2]);
            }
            if (row1 != row2) {
                for (int col = col2 - 1; col >= col1; col--) {
                    rt.add(matrix[row2][col]);
                }
            }
            if (col1 != col2) {
                for (int row = row2 - 1; row >= row1; row--) {
                    rt.add(matrix[row][col1]);
                }
            }
            col1++;
            row1++;
            col2--;
            row2--;
        }
        return rt;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}, {5}};
        PrintMatrixClockwise o = new PrintMatrixClockwise();
        o.printMatrix(matrix);
    }
}
