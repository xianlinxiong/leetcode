package leetcode.panda.chapter0042;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution2 {
    public static void main(String[] args) {
//        int[] candidate = {2, 0, 2};
//        int[] candidate = {5, 2,1, 2,1,5};
//        int[] candidate = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] candidate = {5, 4, 1, 2};
//        int[] candidate = {2,1,0,2};
        int[][] test = {{4, 2, 3},
                {2, 0, 2},
                {5, 2, 1, 2, 1, 5},
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {5, 4, 1, 2},
                {2, 1, 0, 2}
        };
        Solution2 s = new Solution2();
        System.out.println(s.trap(test[3]));
        s.trap(test[3]);
        for (int[] a : test) {
            System.out.println(s.trap(a));
        }
    }

    /**
     * 第一步计算高度数组中的此后最大高度数组
     * 用start开始从0遍历：
     * 当height[start]<height[start+1];start往后偏移
     * end=start+1开始遍历：
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (i < height.length && height[i] <= height[stack.peek()]) {
                stack.push(i);
                i++;
            }
            if (i == height.length) {
                break;
            } else {
                result += count(height, stack, i);
                stack.push(i);
            }
        }
        int last = stack.pop();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int d = 0;
            for(int i = cur+1; i< last; i++){
                d += height[i];
            }
            int distance = last - cur-1;
            int temp = height[last] * distance -d;
            result += temp;
            last = cur;
        }

        return result;
    }

    private int count(int[] height, Stack<Integer> stack, int index) {
        int cur = index;
        int d = 0;
        while (!stack.isEmpty() && height[stack.peek()] <= height[index]) {
            cur = stack.pop();
        }
        if(!stack.isEmpty()){
            return 0;
        }
        for(int i = cur; i< index; i++){
            d += height[i];
        }
        int distance = index - cur;
        int temp = height[cur] * distance;
        return temp - d;

    }

}
