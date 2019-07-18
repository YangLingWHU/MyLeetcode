package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class RobotMovingRange13 {
    int count = 0;
    int rows;
    int cols;
    boolean[][] marked;

    /**
     * P92 面试题13 机器人的运动范围
     *
     * @param threshold 阈值
     * @param rows      总行数
     * @param cols      总列数
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        this.rows = rows;
        this.cols = cols;
        marked = new boolean[rows][cols];
        // 起点
        int row = 0;
        int col = 0;
        movingCountCore(threshold, row, col);
        return this.count;
    }

    private void movingCountCore(int threshold, int row, int col) {
        if (row < 0 || row >= this.rows || col < 0 || col >= this.cols || marked[row][col] || !judge(threshold, row, col)) {
            return;
        }
        marked[row][col] = true;
        this.count++;
        // 左
        movingCountCore(threshold, row, col - 1);

        // 下
        movingCountCore(threshold, row + 1, col);

        // 右
        movingCountCore(threshold, row, col + 1);
        // 上
        movingCountCore(threshold, row - 1, col);

//        marked[row][col] = false;

    }

    /**
     * 判断是否可以进入当前格子
     *
     * @param threshold
     * @param row
     * @param col
     * @return
     */
    public boolean judge(int threshold, int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum > threshold ? false : true;
    }
}
