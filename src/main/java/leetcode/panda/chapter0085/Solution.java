package leetcode.panda.chapter0085;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        char[][] chars = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(s.maximalRectangle(chars));
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length < matrix[0].length ? matrix[0].length : matrix.length;
        int m = matrix.length < matrix[0].length ? matrix.length : matrix[0].length;
        int[] height = new int[n];
        int max = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int cur = (m == matrix.length ? matrix[j][i] : matrix[i][j]) - '0';
                if (cur == 0) {
                    height[i] = 0;
                } else {
                    height[i] += cur;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }

    /**
     * 单调栈算法：每个入栈元素必然大于等于栈内元素
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        class Element {
            int value;
            int index;

            Element(int v, int i) {
                value = v;
                index = i;
            }
        }
        if (null == heights || heights.length == 0) {
            return 0;
        }
        Stack<Element> stack = new Stack<>();
        int large = -1;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || stack.peek().value <= heights[i]) {
                stack.push(new Element(heights[i], i));
            } else {
                int curLength = i;
                while (!stack.isEmpty() && stack.peek().value > heights[i]) {
                    Element el = stack.pop();
                    int rectangle = el.value * (i - el.index);
                    if (large < rectangle) {
                        large = rectangle;
                    }
                    curLength = el.index;
                }
                stack.push(new Element(heights[i], curLength));
            }
        }
        while (!stack.isEmpty()) {
            Element el = stack.pop();
            int rectangle = el.value * (heights.length - el.index);
            if (large < rectangle) {
                large = rectangle;
            }
        }
        return large;
    }

}