/**
 * 思路 rowBegin, rowEnd, colBegin, colEnd
 * while (边界 左右和上下) {
 *  左-》右边；上到下；注意更新4个variable
 *  check 边界，避免重复！！！！！！
 *  右->左；下->上
 * }
 */

class spiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
List<Integer> res = new ArrayList<>();
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) { // inclusive!! as innermost element will have begin=end
            // row fixed, left to right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++; // update!!!

            // col fixed, up to down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // ************** must check by experiment **************
            if (rowBegin > rowEnd || colBegin > colEnd) break;
            // row fixed, right to left
            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // col fixed, down to up
            for (int i = rowEnd; i >= rowBegin; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
    public List<Integer> spiralOrder54(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        int index = (rowEnd + 1) * (colEnd + 1);
        while (rowBegin <= rowEnd && colBegin <= colEnd) { // inclusive!! as innermost element will have begin=end
            // row fixed, left to right
            for (int i = colBegin; i <= colEnd && index-- > 0; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++; // update!!!

            // col fixed, up to down
            for (int i = rowBegin; i <= rowEnd && index-- > 0; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // row fixed, right to left
            for (int i = colEnd; i >= colBegin && index-- > 0; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // col fixed, down to up
            for (int i = rowEnd; i >= rowBegin && index-- > 0; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
}

public class spiralMatrixII59 {
    /*
     * define row_begin, row_end, col_begin, col_end
     */
    public int[][] generateMatrix59(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int index = 1; // 1...n
        while (rowBegin <= rowEnd && colBegin <= colEnd) { // inclusive!! as innermost element will have begin=end
            // row fixed, left to right
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = index;
                index++;
            }
            rowBegin++; // update!!!

            // col fixed, up to down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = index;
                index++;
            }
            colEnd--;

            // row fixed, right to left
            for (int i = colEnd; i >= colBegin; i--) {
                res[rowEnd][i] = index;
                index++;
            }
            rowEnd--;

            // col fixed, down to up
            for (int i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = index;
                index++;
            }
            colBegin++;
        }
        return res;
    }
}
/*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
    1 -> 2 -> 3         1 -> 2 -> 3
              4  -->     8 -> 9   4
    7 <- 6 <- 5         7 <- 6 <- 5
    */