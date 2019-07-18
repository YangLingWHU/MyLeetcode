package jianzhi_offer;

public class HasPathInMatrix12 {
    /**
     * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * <p>
     * p89 面试题12
     * <p>
     * 注意输入不是矩阵，需要先将数组转换成矩阵
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1) {
            return false;
        }
        String targetStr = String.valueOf(str);
        char[][] myMatrix = new char[rows][cols];
        boolean[][] marked = new boolean[rows][cols];
        // 转换矩阵
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                myMatrix[i][j] = matrix[index];
                index++;
            }
        }

        // 依次遍历矩阵的每个节点作为起始节点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(myMatrix, marked, i, j, targetStr, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * @param myMatrix   矩阵
     * @param marked
     * @param row        起始节点的行号
     * @param col        起始节点的列号
     * @param targetStr  待求的字符串
     * @param currentLen 当前走过的路径的字符串
     * @return
     */
    private boolean hasPathCore(char[][] myMatrix, boolean[][] marked, int row, int col, String targetStr, int currentLen) {
        if (currentLen == targetStr.length()) {
            return true;
        }
        if (row < 0 || row >= myMatrix.length || col < 0 || col >= myMatrix[0].length || marked[row][col] || targetStr.charAt(currentLen) != myMatrix[row][col]) {
            return false;
        }

        // 查看当前正在遍历的节点是不是target的最后一个字符
        if (currentLen + 1 == targetStr.length() && myMatrix[row][col] == targetStr.charAt(currentLen)) {
            return true;
        }
        // 可以运行到当前这步说明暂时符合要求，接下来遍历四个方向
        currentLen++;
        marked[row][col] = true;
        // 左
        if (col - 1 >= 0 && hasPathCore(myMatrix, marked, row, col - 1, targetStr, currentLen)) {
            return true;
        }
        // 下
        if (row + 1 < myMatrix.length && hasPathCore(myMatrix, marked, row + 1, col, targetStr, currentLen)) {
            return true;
        }
        // 右
        if (col + 1 < myMatrix[0].length && hasPathCore(myMatrix, marked, row, col + 1, targetStr, currentLen)) {
            return true;
        }
        // 上
        if (row - 1 >= 0 && hasPathCore(myMatrix, marked, row - 1, col, targetStr, currentLen)) {
            return true;
        }

        currentLen--;
        marked[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        HasPathInMatrix12 o = new HasPathInMatrix12();
        String a = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] target = {'S', 'L', 'H', 'E', 'C', 'C', 'E', 'I', 'D', 'E', 'J', 'F', 'G', 'G', 'F', 'I', 'E'};
        char[] array = {'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'};
        char[] target2 = {'A','B'};
        char[] array2 = {'A','B'};

        System.out.println(o.hasPath(array2, 1, 1, target2));

    }
}
