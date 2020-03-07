package leetcode.panda.chapter0037;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        solveSudoku(board);
        System.out.println(board);
    }

    /**
     * 从0,0位置开始
     *
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        boolean[][] horizontal = getHorizontal(board);
        boolean[][] vertical = getVertical(board);
        boolean[][][] square = getSquare(board);
        fillNext(board, 0, 0, horizontal, vertical, square);

    }

    /**
     * 按行进行安排数字，每个位置递归遍历
     * @param board
     * @param x
     * @param y
     * @param horizontal
     * @param vertical
     * @param square
     * @return
     */
    private static boolean fillNext(char[][] board, int x, int y, boolean[][] horizontal, boolean[][] vertical, boolean[][][] square) {
        for (int i = x; i < 9; i++) {
            for (int j = y; j < 9; j++) {
                //判定当前位置是否需要填充数字
                if (board[i][j] != '.') {
                    //如果到达行末位置，跳到下一行首
                    if (j == 8) {
                        y = 0;
                        break;
                    }
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    //判断当前元素是否能够进行填充
                    if (!horizontal[i][k] && !vertical[j][k] && !square[i / 3][j / 3][k]) {
                        //填充对应位置
                        boolean result;
                        board[i][j] = (char) (k + '0');
                        horizontal[i][k] = true;
                        vertical[j][k] = true;
                        square[i / 3][j / 3][k] = true;
                        //填充下一位置
                        if (j == 8) {
                            result = fillNext(board, i + 1, 0, horizontal, vertical, square);
                        } else {
                            result = fillNext(board, i, j + 1, horizontal, vertical, square);
                        }

                        if (!result) {
                            horizontal[i][k] = false;
                            vertical[j][k] = false;
                            square[i / 3][j / 3][k] = false;
                            board[i][j] = '.';
                        } else {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 统计每行中每个数字出现的频率
     * @param board
     * @return
     */
    private static boolean[][] getHorizontal(char[][] board) {
        boolean[][] bool = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    bool[i][k] = true;
                }
            }
        }
        return bool;
    }

    /**
     * 统计每列中每个数字出现的频率
     * @param board
     * @return
     */
    private static boolean[][] getVertical(char[][] board) {
        boolean[][] bool = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    bool[j][k] = true;
                }
            }
        }
        return bool;
    }

    /**
     * 9个正方形，标记每个正方形中每个数字的频率
     * @param board
     * @return
     */
    private static boolean[][][] getSquare(char[][] board) {
        boolean[][][] bool = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    bool[i / 3][j / 3][k] = true;
                }
            }
        }
        return bool;
    }


}
