package leetcode.panda.chapter0051;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println(s.solveNQueens(4));
    }

    /**
     * 使用二位数组标记皇后位置：
     *  首先在第一行的每一列尝试放置皇后，递归在下一行的每个位置尝试放置皇后，如果能放置，则继续下一行重复如此操作，如果不能的话回滚上一行
     *  当n个皇后全部放置成功，输出结果
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] queen = new char[n][n];
        for (int i = 0; i < n; i++) {
            initQueen(queen, n);
            queen[0][i] = 'Q';
            getQueen(queen, 1,result);
        }
        return result;
    }

    private void getQueen(char[][] queen, int level, List<List<String>> result) {
        int length = queen.length;
        if (level >= length) {
            List<String> list = new ArrayList<>();
            for(int i =0; i< length;i++){
                list.add(String.valueOf(queen[i]));
            }
            result.add(list);
        }
        for (int j = 0; j < length; j++){
            if(judge(queen, level, j)){
                queen[level][j] = 'Q';
                getQueen(queen, level+1,result);
                queen[level][j]='.';
            }
        }
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