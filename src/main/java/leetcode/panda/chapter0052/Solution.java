package leetcode.panda.chapter0052;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.totalNQueens1(4));
    }

    int count = 0;

    /**
     * 在51的基础上升级改造： 分别用boolean数组记录竖线，左斜线，右斜线，避免冗余的递归选择
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }

    /**
     * 同51
     * @param n
     * @return
     */
    public int totalNQueens1(int n) {
        char[][] queen = new char[n][n];
        int k =0;
        for (int i = 0; i < n; i++) {
            initQueen(queen, n);
            queen[0][i] = 'Q';
             k =getQueen(queen, 1,k);
        }
        return k;
    }

    private int getQueen(char[][] queen, int level, int k) {
        int length = queen.length;
        if (level >= length) {
            return k+1;
        }
        for (int j = 0; j < length; j++){
            if(judge(queen, level, j)){
                queen[level][j] = 'Q';
                k = getQueen(queen, level+1,k);
                queen[level][j]='.';
            }
        }
        return k;
    }

    /**
     * 判断x行y列是否能放置皇后
     *  ——在y列x行之前没有放置皇后
     *  ——左斜线（x+y == i+j） 判断x行之前，注意j>0
     *  ——右斜线（x-y == i-j)
     * @param queen
     * @param x
     * @param y
     * @return
     */
    private boolean judge(char[][] queen, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (queen[i][y] == 'Q') {
                return false;
            }
        }
        int k = x + y;
        for (int i = x-1; i>=0 && k-i<queen.length; i--) {
            if (queen[i][k - i] == 'Q') {
                return false;
            }
        }
        if (x >= y) {
            for (int j = y - 1; j >= 0; j--) {
                int i = j + x - y;
                if (queen[i][j] == 'Q') {
                    return false;
                }
            }
        } else {
            for (int i = x - 1; i >= 0; i--) {
                int j = y - x + i;
                if (queen[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    private void initQueen(char[][] queen, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queen[i][j] = '.';
            }
        }
    }
}