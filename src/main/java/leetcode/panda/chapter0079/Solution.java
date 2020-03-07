package leetcode.panda.chapter0079;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        char[][] board = {
                {'A','A'}
        };
        System.out.println(s.exist(board,"AAA"));
    }

    /**
     * 回溯算法，向上、向下、向左、向右走
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (null == word || word.length() == 0) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }
        boolean[][] notEmpty = new boolean[ board.length][board[0].length];
        boolean result = false;
        for(int i = 0; i<board.length && !result; i++){
            for(int j =0; j < board[0].length && !result; j++){
                result = backTrack(board,i,j,word, 0, notEmpty);
            }
        }

        return result;
    }

    private boolean backTrack(char[][] board, int x, int y, String word, int start, boolean[][] flag) {
        if (board[x][y] == word.charAt(start)) {
            if (start == word.length() - 1) {
                return true;
            }
            flag[x][y] = true;
            //go up
            if (x > 0 && !flag[x - 1][y]) {
                if (backTrack(board, x - 1, y, word, start + 1, flag)) {
                    return true;
                }
            }
            //go down
            if (x < board.length - 1 && !flag[x + 1][y]) {
                if (backTrack(board, x + 1, y, word, start + 1, flag)) {
                    return true;
                }
            }
            // go left
            if(y >0 && !flag[x][y-1]){
                if(backTrack(board, x, y-1, word, start+1, flag)){
                    return true;
                }
            }

            //go right
            if(y < board[0].length-1 && !flag[x][y+1]){
                if(backTrack(board, x, y+1, word, start+1, flag)){
                    return true;
                }
            }
            flag[x][y] = false;
        }
        return false;
    }

}