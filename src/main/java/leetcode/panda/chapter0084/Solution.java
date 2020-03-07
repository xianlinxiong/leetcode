package leetcode.panda.chapter0084;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] heights = {3, 6, 5, 7, 4, 8, 1, 0};
        System.out.println(s.largestRectangleArea(heights));
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